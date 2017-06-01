package com.emranlive.www.ramadan2017.model;

/**
 * Created by Imran on 5/13/2017.
 */

public class Ramadan {

    private String noOfRoja;
    private String date;
    private String sehriTime;
    private String iftarTime;

    public Ramadan(String noOfRoja, String date, String sehriTime, String iftarTime) {
        this.noOfRoja = noOfRoja;
        this.date = date;
        this.sehriTime = sehriTime;
        this.iftarTime = iftarTime;
    }


    public String getNoOfRoja() {
        return noOfRoja;
    }

    public String getDate() {
        return date;
    }

    public String getSehriTime() {
        return sehriTime;
    }

    public String getIftarTime() {
        return iftarTime;
    }
}
