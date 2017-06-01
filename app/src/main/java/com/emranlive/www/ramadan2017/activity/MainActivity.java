package com.emranlive.www.ramadan2017.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v7.app.AlertDialog;

import com.emranlive.www.ramadan2017.R;
import com.emranlive.www.ramadan2017.adapter.RamadanAdapter;
import com.emranlive.www.ramadan2017.model.Ramadan;
import com.emranlive.www.ramadan2017.other.MySharedPref;
import com.emranlive.www.ramadan2017.other.RamadanData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView1;
    TextView distTextView;
    String district;

    private final int REQUEST_DISTRICT_CODE = 11;
    MySharedPref pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pref = new MySharedPref(MainActivity.this);
        distTextView = (TextView) findViewById(R.id.distTextView);
        district = pref.getDistrict();
        distTextView.setText(district);

        recyclerView1 = (RecyclerView) findViewById(R.id.recycler_view1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        restCodeForShowList();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                startActivity(new Intent(MainActivity.this,AlarmActivity.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    //---------------------User defined method------------------------------------


    public void restCodeForShowList(){
        List<Ramadan> list = new ArrayList<>();
        for(int i=0;i<30;i++){
            int sehriTime = RamadanData.sehriTimeMinute1[i];
            int iftarTime = RamadanData.iftarTimeMinute1[i];

            switch (district) {
                case "দিনাজপুর":
                case "লক্ষীপুর":
                case "জয়পুরহাট":
                case "ঠাকুরগাঁও":
                case "বগুড়া":
                case "কক্সবাজার":
                    sehriTime++;
                    break;
                case "মানিকগঞ্জ":
                case "শরিয়তপুর":
                    sehriTime += 2;
                    break;
                case "মাদারীপুর":
                case "ফরিদপুর":
                case "ভোলা":
                case "বরিশাল":
                case "নওগাঁ":
                    sehriTime += 3;
                    break;
                case "পাবনা":
                case "রাজবাড়ী":
                case "নাটোর":
                case "ঝালকাঠি":
                    sehriTime += 4;
                    break;
                case "গোপালগঞ্জ":
                case "মাগুরা":
                case "রাজশাহী":
                case "কুষ্টিয়া":
                case "পটুয়াখালী":
                case "পিরোজপুর":
                    sehriTime += 5;
                    break;
                case "নড়াইল":
                case "বাগেরহাট":
                case "চাঁপাইনবাবগ্নজ":
                case "ঝিনাইদহ":
                case "বরগুনা":
                    sehriTime += 6;
                    break;
                case "খুলনা":
                case "যশোর":
                case "মেহেরপুর":
                case "চুয়াডাঙ্গা":
                    sehriTime += 7;
                    break;
                case "সাতক্ষিরা":
                    sehriTime += 9;
                    break;
                case "গাজীপুর":
                case "পঞ্জগড়":
                case "রংপুর":
                case "চট্রগ্রাম":
                    sehriTime--;
                    break;
                case "নরসিংদী":
                case "কুমিল্লা":
                case "ফেনী":
                case "গাইবান্ধা":
                case "বান্দরবান":
                    sehriTime -= 2;
                    break;
                case "লালমনিরহাট":
                case "শেরপুর":
                case "কুড়িগ্রাম":
                case "রাঙ্গামাটি":
                    sehriTime -= 3;
                    break;
                case "কিশোরগঞ্জ":
                case "ব্রাহ্মণবাড়িয়া":
                    sehriTime -= 4;
                    break;
                case "নেত্রকোনা":
                case "খাগড়াছড়ি":
                    sehriTime -= 5;
                    break;
                case "হবিগঞ্জ":
                    sehriTime -= 6;
                    break;
                case "সুনামগঞ্জ":
                case "মৌলভীবাজার":
                    sehriTime -= 8;
                    break;
                case "সিলেট":
                    sehriTime -= 9;
                    break;
            }
//---------------- increment or decrement for iftari -------------------------
            switch (district) {
                case "মানিকগঞ্জ":
                case "ফরিদপুর":
                case "ময়মনসিংহ":
                case "খুলনা":
                    iftarTime++;
                    break;
                case "নড়াইল":
                case "টাঙ্গাইল":
                    iftarTime += 2;
                    break;
                case "মাগুরা":
                case "শেরপুর":
                case "সিরাজগঞ্জ":
                case "যশোর":
                case "সাতক্ষিরা":
                    iftarTime += 3;
                    break;
                case "জামালপুর":
                case "রাজবাড়ী":
                case "ঝিনাইদহ":
                    iftarTime += 4;
                    break;
                case "কুষ্টিয়া":
                case "চুয়াডাঙ্গা":
                case "পাবনা":
                    iftarTime += 5;
                    break;
                case "গাইবান্ধা":
                case "নাটোর":
                case "বগুড়া":
                    iftarTime += 6;
                    break;
                case "রাজশাহী":
                case "নওগাঁ":
                case "মেহেরপুর":
                case "কুড়িগ্রাম":
                    iftarTime += 7;
                    break;
                case "রংপুর":
                case "জয়পুরহাট":
                case "লালমনিরহাট":
                    iftarTime += 8;
                case "চাঁপাইনবাবগ্নজ":
                case "দিনাজপুর":
                case "নীলফামারী":
                    iftarTime += 10;
                    break;
                case "পঞ্জগড়":
                case "ঠাকুরগাঁও":
                    iftarTime += 12;
                    break;
                case "নারায়নগঞ্জ":
                case "কিশোরগঞ্জ":
                case "মাদারীপুর":
                case "পিরোজপুর":
                    iftarTime--;
                    break;
                case "ঝালকাঠি":
                case "শরিয়তপুর":
                case "মুন্সিগঞ্জ":
                case "নরসিংদী":
                case "সুনামগঞ্জ":
                    iftarTime -= 2;
                    break;
                case "পটুয়াখালী":
                case "হবিগঞ্জ":
                case "ব্রাহ্মণবাড়িয়া":
                case "বরগুনা":
                case "বরিশাল":
                case "চাঁদপুর":
                    iftarTime -= 3;
                    break;
                case "ভোলা":
                case "লক্ষীপুর":
                case "সিলেট":
                case "কুমিল্লা":
                    iftarTime -= 4;
                    break;
                case "নোয়াখালী":
                case "মৌলভীবাজার":
                    iftarTime -= 5;
                    break;
                case "ফেনী":
                    iftarTime -= 6;
                    break;
                case "খাগড়াছড়ি":
                    iftarTime -= 8;
                    break;
                case "চট্রগ্রাম":
                    iftarTime -= 9;
                    break;
                case "রাঙ্গামাটি":
                    iftarTime -= 10;
                    break;
                case "বান্দরবান":
                case "কক্সবাজার":
                    iftarTime -= 10;
                    break;
            }

            Ramadan ramadan = new Ramadan(RamadanData.noArray1[i],RamadanData.dateArray1[i],"3:"+sehriTime+"AM","6:"+iftarTime+"PM");
            list.add(ramadan);
        }
        recyclerView1.setAdapter(new RamadanAdapter(list,R.layout.item_layout));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(REQUEST_DISTRICT_CODE == requestCode){
            district = pref.getDistrict();
            distTextView.setText(district);
            restCodeForShowList();
        }

    }

    //---------------------Over ridden method by default-----------------------------------------

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about_me) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Imran Shaon");
            builder.setMessage("CSE 13th Batch, DUET\nemran.cse@duet.ac.bd");
            builder.setIcon(R.drawable.imran);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_iftar_sehri_doya) {
            startActivity(new Intent(MainActivity.this, DoyaActivity.class));
        } else if (id == R.id.nav_ramajan_rules) {
            startActivity(new Intent(MainActivity.this, RuleActivity.class));

        } else if (id == R.id.nav_related_doya) {
            startActivity(new Intent(MainActivity.this, NecessaryDoyaActivity.class));

        } else if (id == R.id.nav_thirty_ramajan_doya) {
            startActivity(new Intent(MainActivity.this, DoyaAllActivity.class));

        } else if (id == R.id.nav_select_district) {
            startActivityForResult(new Intent(MainActivity.this,SelectDistrict.class),REQUEST_DISTRICT_CODE);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
