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
import net.mk786110.silahemomin.ViewDuas.DuaAbumhaza3Activity;
import net.mk786110.silahemomin.ViewDuas.DuaArafahActivity;
import net.mk786110.silahemomin.ViewDuas.DuaIftitahActivity;
import net.mk786110.silahemomin.ViewDuas.DuaImamZamanaActivity;
import net.mk786110.silahemomin.ViewDuas.DuaJoshanKabeerActivity;
import net.mk786110.silahemomin.ViewDuas.DuaKumailActivity;
import net.mk786110.silahemomin.ViewDuas.DuaMujeerActivity;
import net.mk786110.silahemomin.ViewDuas.DuaNudbahActivity;
import net.mk786110.silahemomin.ViewDuas.DuaSamatActivity;
import net.mk786110.silahemomin.ViewDuas.DuaTawassulActivity;
public class DuasActivity extends AppCompatActivity {


    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_duas);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.dualayout));
//banner ads
        mAdView = (AdView) findViewById(R.id.dua_adView);
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



    public void onClickDuaeKuamil(View view) {
        C.helperMethods.getStartActivity(DuaKumailActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeIftitah(View view) {
        C.helperMethods.getStartActivity(DuaIftitahActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeTawssul(View view) {
        C.helperMethods.getStartActivity(DuaTawassulActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeJoshanKabir(View view) {
        C.helperMethods.getStartActivity(DuaJoshanKabeerActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeAbuHamza(View view) {
        C.helperMethods.getStartActivity(DuaAbuhamzaActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeImamZamana(View view) {
        C.helperMethods.getStartActivity(DuaImamZamanaActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeSamat(View view) {
        C.helperMethods.getStartActivity(DuaSamatActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeMujeer(View view) {
        C.helperMethods.getStartActivity(DuaMujeerActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeNudbah(View view) {
        C.helperMethods.getStartActivity(DuaNudbahActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickDuaeArafah(View view) {
        C.helperMethods.getStartActivity(DuaArafahActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
