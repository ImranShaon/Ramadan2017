package com.emranlive.www.ramadan2017.model;

/**
 * Created by Imran on 5/17/2017.
 */

public class ExtraDoya {
    private String doyaTitle;
    private String doyaDetails;

    public ExtraDoya(String doyaTitle, String doyaDetails) {
        this.doyaTitle = doyaTitle;
        this.doyaDetails = doyaDetails;
    }

    public String getDoyaTitle() {
        return doyaTitle;
    }

    public String getDoyaDetails() {
        return doyaDetails;
    }
}
