package net.mk786110.silahemomin.SilaheMomin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewAza.MuharramNineDinActivity;
import net.mk786110.silahemomin.ViewAza.MuharramPhelaDinActivity;
import net.mk786110.silahemomin.ViewAza.MuharramPheliRatActivity;
import net.mk786110.silahemomin.ViewAza.MuharramRozeAshurActivity;
import net.mk786110.silahemomin.ViewAza.MuharramShabeAshurActivity;
import net.mk786110.silahemomin.ViewAza.MuharramTisraDinActivity;
import net.mk786110.silahemomin.ViewAza.SafarAttaesActivity;
import net.mk786110.silahemomin.ViewAza.SafarChehlumActivity;


public class AzaActivity extends AppCompatActivity {


    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_aza);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.dualayout));
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



    public void onClickSafarAttaes(View view) {
        C.helperMethods.getStartActivity(SafarAttaesActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickSafarChehlum(View view) {
        C.helperMethods.getStartActivity(SafarChehlumActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramrozeashu(View view) {
        C.helperMethods.getStartActivity(MuharramRozeAshurActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramsahbeashur(View view) {
        C.helperMethods.getStartActivity(MuharramShabeAshurActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramninedin(View view) {
        C.helperMethods.getStartActivity(MuharramNineDinActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharramtisradin(View view) {
        C.helperMethods.getStartActivity(MuharramTisraDinActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharrampheldin(View view) {
        C.helperMethods.getStartActivity(MuharramPhelaDinActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMuharrampheliRat(View view) {
        C.helperMethods.getStartActivity(MuharramPheliRatActivity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
