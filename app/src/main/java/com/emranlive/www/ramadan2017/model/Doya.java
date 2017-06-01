package com.emranlive.www.ramadan2017.model;

/**
 * Created by Imran on 5/14/2017.
 */

public class Doya {
    private String noOfRamadan;
    private String doyaArabic;
    private String doyaBangla;

    public Doya(String noOfRamadan, String doyaArabic, String doyaBangla) {
        this.noOfRamadan = noOfRamadan;
        this.doyaArabic = doyaArabic;
        this.doyaBangla = doyaBangla;
    }

    public String getNoOfRamadan() {
        return noOfRamadan;
    }

    public String getDoyaArabic() {
        return doyaArabic;
    }

    public String getDoyaBangla() {
        return doyaBangla;
    }
}
