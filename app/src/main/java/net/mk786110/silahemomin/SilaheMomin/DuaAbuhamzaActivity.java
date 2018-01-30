package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.startapp.android.publish.StartAppSDK;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewAza.MuharramPheliRatActivity;
import net.mk786110.silahemomin.ViewDuas.DuaAbumhaza1Activity;
import net.mk786110.silahemomin.ViewDuas.DuaAbumhaza2Activity;
import net.mk786110.silahemomin.ViewDuas.DuaAbumhaza3Activity;


public class DuaAbuhamzaActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dua_abuhamza_parts);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.duaabuhamzapartslayout));

        mAdView = (AdView) findViewById(R.id.hamza_adView);
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

    public void onClickAbuhamzaPart1(View view) {
        C.helperMethods.getStartActivity(DuaAbumhaza1Activity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickAbuhamzaPart2(View view) {
        C.helperMethods.getStartActivity(DuaAbumhaza2Activity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickAbuhamzaPart3(View view) {
        C.helperMethods.getStartActivity(DuaAbumhaza3Activity.class,this);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
