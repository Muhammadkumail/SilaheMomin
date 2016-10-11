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

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewAza.MuharramNineDinActivity;
import net.mk786110.silahemomin.ViewAza.MuharramPhelaDinActivity;
import net.mk786110.silahemomin.ViewAza.MuharramPheliRatActivity;
import net.mk786110.silahemomin.ViewAza.MuharramRozeAshurActivity;
import net.mk786110.silahemomin.ViewAza.MuharramShabeAshurActivity;
import net.mk786110.silahemomin.ViewAza.MuharramTisraDinActivity;
import net.mk786110.silahemomin.ViewAza.SafarAttaesActivity;
import net.mk786110.silahemomin.ViewAza.SafarChehlumActivity;
import net.mk786110.silahemomin.ViewDuas.DuaArafahActivity;
import net.mk786110.silahemomin.ViewDuas.DuaIftitahActivity;
import net.mk786110.silahemomin.ViewDuas.DuaImamZamanaActivity;
import net.mk786110.silahemomin.ViewDuas.DuaJoshanKabeerActivity;
import net.mk786110.silahemomin.ViewDuas.DuaKumailActivity;
import net.mk786110.silahemomin.ViewDuas.DuaMujeerActivity;
import net.mk786110.silahemomin.ViewDuas.DuaNudbahActivity;
import net.mk786110.silahemomin.ViewDuas.DuaSamatActivity;
import net.mk786110.silahemomin.ViewDuas.DuaTawassulActivity;

public class AzaActivity extends AppCompatActivity {


    private AdView mAdView;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aza);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.dualayout));
//banner ads
        mAdView = (AdView) findViewById(R.id.dua_adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        // full scren ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2985848238387199/3946588264");
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



    public void onClickSafarAttaes(View view) {
        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, SafarAttaesActivity.class);
        startActivity(intent);


        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickSafarChehlum(View view) {
        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, SafarChehlumActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramrozeashu(View view) {

        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, MuharramRozeAshurActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramsahbeashur(View view) {
        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, MuharramShabeAshurActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramninedin(View view) {
        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, MuharramNineDinActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramtisradin(View view) {
        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, MuharramTisraDinActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharrampheldin(View view) {
        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, MuharramPhelaDinActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharrampheliRat(View view) {
        Intent intent = new Intent();
        intent.setClass(AzaActivity.this, MuharramPheliRatActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
