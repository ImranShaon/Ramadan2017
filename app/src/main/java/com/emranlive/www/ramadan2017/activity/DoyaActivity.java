package com.emranlive.www.ramadan2017.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.emranlive.www.ramadan2017.R;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class DoyaActivity extends AppCompatActivity {

    private TextView sehriBanglaTexView,sehrirNiyotTextView,iftarBanglaTextView,iftarirDoyaTextView;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doya);

        mAdView = (AdView) findViewById(R.id.doyaAdView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        initializeAll();
    }

    private void initializeAll(){
        sehriBanglaTexView = (TextView) findViewById(R.id.sehriBanglaTexView);
        sehrirNiyotTextView = (TextView) findViewById(R.id.sehrirNiyotTextView);
        iftarBanglaTextView = (TextView) findViewById(R.id.iftarBanglaTextView);
        iftarirDoyaTextView = (TextView) findViewById(R.id.iftarirDoyaTextView);

        Typeface typeface1 = Typeface.createFromAsset(getAssets(),"font/kalpurush.ttf");
        sehriBanglaTexView.setText(R.string.sehri_doya_bangla);
        sehriBanglaTexView.setTypeface(typeface1);
        iftarBanglaTextView.setText(R.string.iftar_doya_bangla);
        iftarBanglaTextView.setTypeface(typeface1);

        Typeface typeface2 = Typeface.createFromAsset(getAssets(),"font/BenSenHandwriting.ttf");
        sehrirNiyotTextView.setText(R.string.sheri_doya_meaning);
        sehrirNiyotTextView.setTypeface(typeface2);
        iftarirDoyaTextView.setText(R.string.iftar_doya_meaning);
        iftarirDoyaTextView.setTypeface(typeface2);


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
