package com.emranlive.www.ramadan2017.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.adapter.DoyaAdapter;
import com.emranlive.www.ramadan2017.adapter.ExtraDoyaAdapter;
import com.emranlive.www.ramadan2017.model.Doya;
import com.emranlive.www.ramadan2017.model.ExtraDoya;
import com.emranlive.www.ramadan2017.other.DoyaData;
import com.emranlive.www.ramadan2017.other.extraDoyaData;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.List;

public class NecessaryDoyaActivity extends AppCompatActivity {


    private List<ExtraDoya> list;
    private ExtraDoyaAdapter adapter;
    private RecyclerView recycler_view_extra_doya;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_necessary_doya);


        mAdView = (AdView) findViewById(R.id.extraDoyaAdView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        initializeAll();
    }

    private void initializeAll(){
        recycler_view_extra_doya = (RecyclerView) findViewById(R.id.recycler_view_extra_doya);
        recycler_view_extra_doya.setLayoutManager(new LinearLayoutManager(NecessaryDoyaActivity.this));
        list = new ArrayList<>();
        for (int i=0;i<29;i++){
            ExtraDoya extraDoya = new ExtraDoya(extraDoyaData.titleArray[i],extraDoyaData.detailsArray[i]);
            list.add(extraDoya);
        }
        adapter = new ExtraDoyaAdapter(list);
        recycler_view_extra_doya.setAdapter(adapter);
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
