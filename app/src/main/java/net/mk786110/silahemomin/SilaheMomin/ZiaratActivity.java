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
import net.mk786110.silahemomin.ViewSurahs.SurahYaseenActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratAshuraActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratHazratAbbasActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratHazratAliIbnHussainActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratImamHussainActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratSayerShohadaActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratWarisActivity;

public class ZiaratActivity extends AppCompatActivity {

    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ziarat);

        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.ziaratlayout));

        mAdView = (AdView) findViewById(R.id.ziarat_adView);
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

    public void onClickziaratAshura(View view) {
        C.helperMethods.getStartActivity(ZiaratAshuraActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaraWaresah(View view) {
        C.helperMethods.getStartActivity(ZiaratWarisActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratImamHussain(View view) {
        C.helperMethods.getStartActivity(ZiaratImamHussainActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratHazratAlibinHussain(View view) {
        C.helperMethods.getStartActivity(ZiaratHazratAliIbnHussainActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratSaerShohada(View view) {
        C.helperMethods.getStartActivity(ZiaratSayerShohadaActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratHazratAbbas(View view) {
        C.helperMethods.getStartActivity(ZiaratHazratAbbasActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

}
