package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.startapp.android.publish.StartAppSDK;


import net.mk786110.silahemomin.R;

import net.mk786110.silahemomin.ViewShaban.ShabanMushtarekaAmalActivity;
import net.mk786110.silahemomin.ViewShaban.ShabanNimeShabanActivity;
import net.mk786110.silahemomin.ViewShaban.ShabanThirdNightActivity;

public class AmaleShabanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "205588646", true);
        setContentView(R.layout.activity_shaban);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.amalshabanlaayout));

    }



    public void onClicktesriShaban(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleShabanActivity.this, ShabanThirdNightActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickNimeShabana(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleShabanActivity.this, ShabanNimeShabanActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickshaban_mushtarekaAmal(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleShabanActivity.this, ShabanMushtarekaAmalActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
