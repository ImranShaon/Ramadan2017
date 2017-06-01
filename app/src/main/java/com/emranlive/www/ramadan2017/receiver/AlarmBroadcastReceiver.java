package com.emranlive.www.ramadan2017.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.emranlive.www.ramadan2017.service.AlarmService;

/**
 * Created by Imran on 5/10/2017.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("--Broadcast Receiver--","Start Broadcast Receiver");

        //fetch the extra string form the intent
        String extraString = intent.getExtras().getString("EXTRA");

        Log.e("--Broadcast Receiver--","Your Extra String is: "+extraString);


        //create an intent for the alarm service.
        Intent intentService = new Intent(context, AlarmService.class);

        //pass the extra string to the alarm service which comes from alarm activity
        intentService.putExtra("EXTRA",extraString);

        //start the alarm service
        context.startService(intentService);

        Log.e("--Broadcast Receiver--","End Broadcast Receiver");
    }
}
