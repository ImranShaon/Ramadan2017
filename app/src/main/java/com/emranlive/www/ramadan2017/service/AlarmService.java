package com.emranlive.www.ramadan2017.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.activity.AlarmActivity;

/**
 * Created by Imran on 5/10/2017.
 */

public class AlarmService extends Service {

    private Ringtone ringtone;
    private int key;
    private boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("--Alarm Service--","Start Alarm Service");

        //fetch extra string from intent
        String extraString = intent.getExtras().getString("EXTRA");

        Log.e("--Alarm Service--","Your extra string is : "+extraString);

        //this block of code convert the extra string into 0 or 1
        assert extraString !=null;
        switch (extraString){
            case "alarm on":
                key = 1;
                break;
            case "alarm off":
                key = 0;
                break;
            default:
                key = 0;
                break;
        }

        //if else statements
        // if there is no music playing and user press the "alarm on" button
        if(key==1 && !isRunning){

            //initialize the uri for select the default alarm ringtone path
            Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

            //if there is no default ringtone for alarm then select the notification ringtone path
            if(uri == null) {
                uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            }

            //initialize the ringtone instance with the ringtone path
            ringtone = RingtoneManager.getRingtone(this, uri);

            //start the ringtone
            ringtone.play();


            //tell that the alarm is already running
            key = 0;
            isRunning = true;

            //notification
            //set up the notification service
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent intent_main_activity = new Intent(this.getApplicationContext(),AlarmActivity.class);
            PendingIntent pending_intent_main_activity = PendingIntent.getActivity(this,0,intent_main_activity,0);

            Notification notification = new Notification.Builder(this)
                    .setContentTitle("মাহে রমাজান ২০১৭")
                    .setContentText("এলার্ম বন্ধ করতে এখানে ক্লিক করুন!")
                    .setContentIntent(pending_intent_main_activity)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .setAutoCancel(true)
                    .build();

            //set up notification start command
            notificationManager.notify(0,notification);

        }
        //if there music is playing and user press "alarm off"
        //ringtone should stop playing
        else if (isRunning && key==0){

            //stop the ringtone
            ringtone.stop();

            key = 0;
            isRunning = false;
        }

        //if there is no music and the user press "alarm off" button
        //do nothing
        else if (key==0 && !isRunning){
            key = 0;
            isRunning = false;
        }

        //if the ringtone is playing and the user press the "alarm on" button
        else if(key==1 && isRunning){
            key = 1;
            isRunning = true;
        }
        // can't reach this block of code.
        else{
            Log.e("else ","Some how you reach there. . .");
        }


        Log.e("--Alarm Service--","End Alarm Service");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //initialize the ringtone is not playing
        isRunning = false;
    }
}
