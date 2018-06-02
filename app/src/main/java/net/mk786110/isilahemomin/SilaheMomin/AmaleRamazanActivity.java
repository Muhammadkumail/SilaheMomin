package net.mk786110.isilahemomin.SilaheMomin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import net.mk786110.isilahemomin.Constant.C;
import net.mk786110.isilahemomin.R;

import net.mk786110.isilahemomin.ViewRamzan.RamzanMunajatActivity;
import net.mk786110.isilahemomin.ViewRamzan.RamzanMushtarekaAmalActivity;
import net.mk786110.isilahemomin.ViewRamzan.RamzanShabe19Activity;
import net.mk786110.isilahemomin.ViewRamzan.RamzanShabe21Activity;
import net.mk786110.isilahemomin.ViewRamzan.RamzanShabe23Activity;

public class AmaleRamazanActivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ramaza);

        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.amalramzanlaayout));
//        mAdView = (AdView) findViewById(R.id.ramzan_adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
    }

//    @Override
//    public void onPause() {
//        if (mAdView != null) {
//            mAdView.pause();
//        }
//        super.onPause();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        if (mAdView != null) {
//            mAdView.resume();
//        }
//    }
//
//    @Override
//    public void onDestroy() {
//        if (mAdView != null) {
//            mAdView.destroy();
//        }
//        super.onDestroy();
//    }

    public void onClickMushtarekAmal(View view) {
        C.helperMethods.getStartActivity(RamzanMushtarekaAmalActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickShabeUnnis(View view) {

        C.helperMethods.getStartActivity(RamzanShabe19Activity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickShabeIkkis(View view) {
        C.helperMethods.getStartActivity(RamzanShabe21Activity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickShabeTeyyes(View view) {
        C.helperMethods.getStartActivity(RamzanShabe23Activity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickRamzanMunajat(View view) {
        C.helperMethods.getStartActivity(RamzanMunajatActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
