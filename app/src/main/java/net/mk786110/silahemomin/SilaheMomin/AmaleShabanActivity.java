package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.R;

import net.mk786110.silahemomin.ViewRamzan.RamzanMushtarekaAmalActivity;
import net.mk786110.silahemomin.ViewShaban.ShabanMushtarekaAmalActivity;
import net.mk786110.silahemomin.ViewShaban.ShabanNimeShabanActivity;
import net.mk786110.silahemomin.ViewShaban.ShabanThirdNightActivity;

public class AmaleShabanActivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shaban);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.amalshabanlaayout));

        mAdView = (AdView) findViewById(R.id.shaban_adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
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



    public void onClicktesriShaban(View view) {
        C.helperMethods.getStartActivity(ShabanThirdNightActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickNimeShabana(View view) {
        C.helperMethods.getStartActivity(ShabanNimeShabanActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickshaban_mushtarekaAmal(View view) {
        C.helperMethods.getStartActivity(ShabanMushtarekaAmalActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
