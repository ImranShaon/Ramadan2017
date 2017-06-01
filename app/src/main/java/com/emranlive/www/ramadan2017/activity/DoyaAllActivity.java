package com.emranlive.www.ramadan2017.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.adapter.DoyaAdapter;
import com.emranlive.www.ramadan2017.model.Doya;
import com.emranlive.www.ramadan2017.other.DoyaData;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class DoyaAllActivity extends AppCompatActivity {

    private List<Doya> list;
    DoyaAdapter adapter;
    RecyclerView recycler_view_doya;


    private AdView doyaAllAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doya_all);



        doyaAllAdView = (AdView) findViewById(R.id.doyaAllAdView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        doyaAllAdView.loadAd(adRequest);

        recycler_view_doya = (RecyclerView) findViewById(R.id.recycler_view_doya);
        recycler_view_doya.setLayoutManager(new LinearLayoutManager(DoyaAllActivity.this));
        list = new ArrayList<>();
        for (int i=0;i<30;i++){
            Doya doya = new Doya(DoyaData.doyaTitle[i]+" রমজানের দোয়া",DoyaData.doyaArabic[i],DoyaData.doyaBangla[i]);
            list.add(doya);
        }
        adapter = new DoyaAdapter(list);
        recycler_view_doya.setAdapter(adapter);
    }


    @Override
    public void onPause() {
        if (doyaAllAdView != null) {
            doyaAllAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (doyaAllAdView != null) {
            doyaAllAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (doyaAllAdView != null) {
            doyaAllAdView.destroy();
        }
        super.onDestroy();
    }
}
