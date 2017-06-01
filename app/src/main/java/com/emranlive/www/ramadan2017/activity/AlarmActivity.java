package com.emranlive.www.ramadan2017.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.other.MySharedPref;
import com.emranlive.www.ramadan2017.receiver.AlarmBroadcastReceiver;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class AlarmActivity extends AppCompatActivity implements View.OnClickListener{

    private TimePicker timePicker;
    private TextView alarmText;
    private Button startButton, stopButton;

    private Calendar calendar;
    private Intent alarmIntent;
    private PendingIntent alarmPendingIntent;
    private AlarmManager alarmManager;

    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    MySharedPref pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);


        //show Interstitial add
        showAdd();

        //show banner add
        mAdView = (AdView) findViewById(R.id.alarmAdView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        //initialize all variable
        initializeAll();
    }

    private void initializeAll(){
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmText = (TextView) findViewById(R.id.alarmText);
        startButton = (Button) findViewById(R.id.startButton);
        stopButton = (Button) findViewById(R.id.stopButton);

        pref = new MySharedPref(AlarmActivity.this);
        alarmText.setText(pref.getAlarmTime());

        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);

        calendar = Calendar.getInstance();
        // initialize the broadcast intent.
        alarmIntent = new Intent(AlarmActivity.this, AlarmBroadcastReceiver.class);

        //initialize the alarm manager
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.startButton:
                setAlarmTime();
                break;
            case R.id.stopButton:
                cancelAlarmTime();
                break;
        }
    }

    private void setAlarmTime(){

        //initialize the calendar with the hour and minute from time picker
        calendar.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
        calendar.set(Calendar.MINUTE,timePicker.getCurrentMinute());

        //get the int value of the hour and minute
        int hour = timePicker.getCurrentHour();
        int minute = timePicker.getCurrentMinute();



        if(hour>12){
            hour = hour-12;
            //set message to the Text View
            setAlarmText("Alarm time "+hour+":"+minute+" PM");
        }
        else if(hour==12){
            setAlarmText("Alarm time  12:"+minute+" PM");
        }
        else{
            setAlarmText("Alarm time "+hour+":"+minute+" AM");
        }




        //put the extra into alarm intent to tell the clock the you press "alarm on" button
        alarmIntent.putExtra("EXTRA","alarm on");

        //initialize the pending intent with alarm intent
        alarmPendingIntent = PendingIntent.getBroadcast(AlarmActivity.this,11,alarmIntent,PendingIntent.FLAG_UPDATE_CURRENT);


        //start the broadcast receiver
        //set the alarm manager
        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),alarmPendingIntent);
    }

    private void cancelAlarmTime(){

        //method that change the text of the TextView
        setAlarmText("Alarm is off");

        //cancel the alarm
        alarmManager.cancel(alarmPendingIntent);

        //put extra string into alarm intent to tell the clock that you press "alarm off" button
        alarmIntent.putExtra("EXTRA","alarm off");

        //stop the ringtone
        sendBroadcast(alarmIntent);

    }

    private void setAlarmText(String text){
        pref.setAlarmTime(text);
        alarmText.setText(pref.getAlarmTime());
    }

    private void showAdd(){
        mInterstitialAd = new InterstitialAd(this);

        // set the ad unit ID
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen));

        AdRequest adRequest = new AdRequest.Builder()
                .build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequest);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });
    }
    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }



    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
    }
}
