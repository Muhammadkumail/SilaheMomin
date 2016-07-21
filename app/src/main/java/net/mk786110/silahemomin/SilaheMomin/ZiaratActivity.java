package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import net.mk786110.silahemomin.R;
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
        Intent intent = new Intent();
        intent.setClass(ZiaratActivity.this, ZiaratAshuraActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickZiaraWaresah(View view) {
        Intent intent = new Intent();
        intent.setClass(ZiaratActivity.this, ZiaratWarisActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratImamHussain(View view) {
        Intent intent = new Intent();
        intent.setClass(ZiaratActivity.this, ZiaratImamHussainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratHazratAlibinHussain(View view) {
        Intent intent = new Intent();
        intent.setClass(ZiaratActivity.this, ZiaratHazratAliIbnHussainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratSaerShohada(View view) {
        Intent intent = new Intent();
        intent.setClass(ZiaratActivity.this, ZiaratSayerShohadaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickZiaratHazratAbbas(View view) {
        Intent intent = new Intent();
        intent.setClass(ZiaratActivity.this, ZiaratHazratAbbasActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

}
