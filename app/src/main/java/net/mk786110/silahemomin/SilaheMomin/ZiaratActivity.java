package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.startapp.android.publish.StartAppSDK;


import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewZiarats.ZiaratAshuraActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratHazratAbbasActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratHazratAliIbnHussainActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratImamHussainActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratSayerShohadaActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratWarisActivity;

public class ZiaratActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "205588646", true);
        setContentView(R.layout.activity_ziarat);

        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.ziaratlayout));

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
