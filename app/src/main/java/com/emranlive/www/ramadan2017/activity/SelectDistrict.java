package com.emranlive.www.ramadan2017.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.other.DistrictNameData;
import com.emranlive.www.ramadan2017.other.MySharedPref;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import fr.ganfra.materialspinner.MaterialSpinner;

public class SelectDistrict extends AppCompatActivity {

    String[] districtList;
    ArrayAdapter<String> arrayAdapter2;

    String selectedDistrict;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_district);

        mAdView = (AdView) findViewById(R.id.selectDistAdView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        showSpinner();
    }

    private void showSpinner(){
        final String[] divisionList = DistrictNameData.divisionName;

        //initialize the division list with constant name
        districtList = DistrictNameData.dhakaDivision;

        //create array adapter
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, divisionList);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final MaterialSpinner spinner1 = (MaterialSpinner) findViewById(R.id.spinner1);
        spinner1.setAdapter(arrayAdapter1);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                // select the district list according to the division
                switch (position) {
                    case 0:
                        districtList = DistrictNameData.dhakaDivision;
                        break;
                    case 1:
                        districtList = DistrictNameData.ctgDivision;
                        break;
                    case 2:
                        districtList = DistrictNameData.khulnaDivision;
                        break;
                    case 3:
                        districtList = DistrictNameData.rajshahiDivision;
                        break;
                    case 4:
                        districtList = DistrictNameData.barisalDivision;
                        break;
                    case 5:
                        districtList = DistrictNameData.rangpurDivision;
                        break;
                    case 6:
                        districtList = DistrictNameData.sylhetDivision;
                        break;
                    case 7:
                        districtList = DistrictNameData.mymansingDivision;
                        break;
                    default:
                        districtList = DistrictNameData.dhakaDivision;
                        break;
                }
                arrayAdapter2 = new ArrayAdapter<String>(SelectDistrict.this,android.R.layout.simple_spinner_item, districtList);
                arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                MaterialSpinner spinner2 = (MaterialSpinner) findViewById(R.id.spinner2);
                spinner2.setAdapter(arrayAdapter2);
                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        selectedDistrict = adapterView.getItemAtPosition(i).toString();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                        Toast.makeText(getApplicationContext(),"Error occurred while selecting district.",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getApplicationContext(),"Error occurred while selecting division.",Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void saveData(View view){
        if(!selectedDistrict.equals("জেলা")) {
            MySharedPref pref = new MySharedPref(SelectDistrict.this);
            pref.setDistrict(selectedDistrict);
        }
        finish();
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
