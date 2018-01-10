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

import net.mk786110.silahemomin.ViewRajab.RajabFirstNightActivity;
import net.mk786110.silahemomin.ViewRajab.RajabMushtarekaAmalActivity;
import net.mk786110.silahemomin.ViewRajab.RajabShabe27Activity;
import net.mk786110.silahemomin.ViewRajab.RajabTeraToPandraActivity;
import net.mk786110.silahemomin.ViewRajab.RajabUmmeDawoodActivity;
import net.mk786110.silahemomin.ViewRajab.RajabZiaratRajabeaActivity;

public class AmaleRajabActivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_rajab);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.amalrajablaayout));
        mAdView = (AdView) findViewById(R.id.rajab_adView);
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

    public void onClickRajabPheliRat(View view) {
        C.helperMethods.getStartActivity(RajabFirstNightActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMushtarekaAmal(View view) {
        C.helperMethods.getStartActivity(RajabMushtarekaAmalActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickZiratRajabea(View view) {
        C.helperMethods.getStartActivity(RajabZiaratRajabeaActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickTeratoPandra(View view) {
        C.helperMethods.getStartActivity(RajabTeraToPandraActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickUmmeDawood(View view) {
        C.helperMethods.getStartActivity(RajabUmmeDawoodActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickRajabShabe27(View view) {
        C.helperMethods.getStartActivity(RajabShabe27Activity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }



}
