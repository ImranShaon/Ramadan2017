package com.emranlive.www.ramadan2017.other;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Imran on 4/27/2017.
 */

public class MySharedPref {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;

    public MySharedPref(Context context){
        this.context = context;
        prefs = context.getSharedPreferences("MY_APP",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setDistrict(String district){
        editor.putString("DISTRICT",district);
        editor.commit();
    }

    public void setAlarmTime(String alarm){
        editor.putString("ALARM",alarm);
        editor.commit();
    }

    public String getDistrict(){
        return prefs.getString("DISTRICT","ঢাকা");
    }

    public String getAlarmTime(){
        return prefs.getString("ALARM","অ্যালার্ম সেট করা হয়নি");
    }
}
