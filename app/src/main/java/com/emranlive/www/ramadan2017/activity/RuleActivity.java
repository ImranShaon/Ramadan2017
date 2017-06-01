package com.emranlive.www.ramadan2017.activity;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.emranlive.www.ramadan2017.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class RuleActivity extends AppCompatActivity {

    TextView breakRojaTextView, makroRojaTextView;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);


        mAdView = (AdView) findViewById(R.id.ruleAdView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        initializeAll();
    }

    private void initializeAll(){
        breakRojaTextView = (TextView) findViewById(R.id.breakRojaTextView);
        makroRojaTextView = (TextView) findViewById(R.id.makroRojaTextView);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/kalpurush.ttf");
        breakRojaTextView.setText("১. ইচ্ছাকৃত পানাহার করলে।\n" +
                "২. স্ত্রী সহবাস করলে ।\n" +
                "৩. কুলি করার সময় হলকের নিচে পানি চলে গেলে (অবশ্য রোজার কথা স্মরণ না থাকলে রোজা ভাঙ্গবে না)।\n" +
                "৪. ইচ্ছকৃত মুখভরে বমি করলে।\n" +
                "৫. নস্য গ্রহণ করা, নাকে বা কানে ওষধ বা তৈল প্রবেশ করালে।\n" +
                "৬. জবরদস্তি করে কেহ রোজা ভাঙ্গালে ।\n" +
                "৭. ইনজেকশান বা স্যালাইরনর মাধ্যমে দেমাগে ওষধ পৌছালে।\n" +
                "৮. কংকর পাথর বা ফলের বিচি গিলে ফেললে।\n" +
                "৯. সূর্যাস্ত হয়েছে মনে করে ইফতার করার পর দেখা গেল সুর্যাস্ত হয়নি।\n" +
                "১০. পুরা রমজান মাস রোজার নিয়ত না করলে।\n" +
                "১১. দাঁত হতে ছোলা পরিমান খাদ্য-দ্রব্য গিলে ফেললে।\n" +
                "১২. ধূমপান করা, ইচ্ছাকৃত লোবান বা আগরবাতি জ্বালায়ে ধোয়া গ্রহন করলে।\n" +
                "১৩. মুখ ভর্তি বমি গিলে ফেললে ।\n" +
                "১৪. রাত্রি আছে মনে করে সোবহে সাদিকের পর পানাহার করলে।\n" +
                "১৫. মুখে পান রেখে ঘুমিয়ে পড়ে সুবহে সাদিকের পর নিদ্রা হতে জাগরিত হওয়া এ অবস্থায় শুধু কাজা ওয়াজিব হবে।");
        breakRojaTextView.setTypeface(typeface);

        makroRojaTextView.setText("১. অনাবশ্যক কোনো জিনিস চিবানো বা চাখা\n" +
                "২. সকোনো দ্রব্য মুখে দিয়ে রাখা ।\n" +
                "৩. গড়গড় করা বা নাকের ভেতর পানি টেনে নেয়া কিন্তু পানি যদি নাক দিয়ে গলায় পৌঁছে যায়, তাহলে রোজা ভেঙে যাবে।\n" +
                "৪. ইচ্ছাকৃত মুখে থুথু জমা করে গলাধঃকরণ করা\n" +
                "৫. গীবত, গালা-গালি ও ঝগড়া-ফাসাদ করা। কেউ গায়ে পড়ে ঝগড়া-ফাসাদ করতে এলে বলবে, আমি রোজাদার তোমাকে প্রত্যুত্থর দিতে অক্ষম\n" +
                "৬. সাড়া দিন নাপাক অবস্থায় থাকা। এটি অত্যন্ত গুনাহের কাজ ।\n" +
                "৭. অস্থিরতা ও কাতরতা প্রকাশ করা\n" +
                "৮. কয়লা চিবিয়ে অথবা পাউডার, পেস্ট ও মাজন ইত্যাদি দ্বারা দাঁত পরিষ্কার করা\n");
        makroRojaTextView.setTypeface(typeface);
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
