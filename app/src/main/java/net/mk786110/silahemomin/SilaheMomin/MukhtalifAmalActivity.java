package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewAmals.RozEidFitrActivity;
import net.mk786110.silahemomin.ViewAmals.RozJummahActivity;
import net.mk786110.silahemomin.ViewAmals.ShabeEidFitrActivity;
import net.mk786110.silahemomin.ViewAmals.ShabeJummahActivity;
import net.mk786110.silahemomin.ViewDuas.DuaArafahActivity;


public class MukhtalifAmalActivity extends AppCompatActivity {

    private AdView mAdView;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mukhtali_amal);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.mukhtaliflayout));


        mAdView = (AdView) findViewById(R.id.mukhtalif_adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // full scren ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2985848238387199/5423321468");
        AdRequest adRequestf = new AdRequest.Builder().build();

        // Load ads into Interstitial Ads
        mInterstitialAd.loadAd(adRequestf);

        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitial();
            }
        });


    }
    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
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

    public void onClickShabeJummah(View view) {
        C.helperMethods.getStartActivity(ShabeJummahActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickShabeEidFitr(View view) {
        C.helperMethods.getStartActivity(ShabeEidFitrActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickRozJummah(View view) {
        C.helperMethods.getStartActivity(RozJummahActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickRozEidFitr(View view) {
        C.helperMethods.getStartActivity(RozEidFitrActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
