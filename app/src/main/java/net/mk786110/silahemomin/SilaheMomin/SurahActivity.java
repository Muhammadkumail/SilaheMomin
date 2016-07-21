package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
;

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewSurahs.SurahAnkabutActivity;
import net.mk786110.silahemomin.ViewSurahs.SurahDukhanActivity;
import net.mk786110.silahemomin.ViewSurahs.SurahRehmanActivity;
import net.mk786110.silahemomin.ViewSurahs.SurahRoomActivity;
import net.mk786110.silahemomin.ViewSurahs.SurahYaseenActivity;

public class SurahActivity extends AppCompatActivity {
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_surah);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.surahlayout));


        mAdView = (AdView) findViewById(R.id.surah_adView);
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
    public void onClickSurahAnkabut(View view)
    {
        Intent intent=new Intent();
        intent.setClass(SurahActivity.this,SurahAnkabutActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickSurahRoom(View view)
    {
        Intent intent=new Intent();
        intent.setClass(SurahActivity.this,SurahRoomActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickSurahDhukahn(View view)
    {
        Intent intent=new Intent();
        intent.setClass(SurahActivity.this,SurahDukhanActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickSurahRehman(View view)
    {
        Intent intent=new Intent();
        intent.setClass(SurahActivity.this,SurahRehmanActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickSurahYaseen(View view)
    {
        Intent intent=new Intent();
        intent.setClass(SurahActivity.this,SurahYaseenActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
