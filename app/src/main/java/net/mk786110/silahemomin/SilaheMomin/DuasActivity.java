package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.startapp.android.publish.StartAppSDK;

import net.mk786110.silahemomin.R;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdBuddiz.setPublisherKey("88de095c-b0c4-4dbc-925a-9649b11d08fb");
        AdBuddiz.cacheAds(this);
        AdBuddiz.showAd(this);
        StartAppSDK.init(this, "205588646", true);
        setContentView(R.layout.activity_duas);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.dualayout));


    }





    public void onClickDuaeKuamil(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaKumailActivity.class);
        startActivity(intent);


        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeIftitah(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaIftitahActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeTawssul(View view) {

        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaTawassulActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeJoshanKabir(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaJoshanKabeerActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeAbuHamza(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaAbuhamzaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeImamZamana(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaImamZamanaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeSamat(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaSamatActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeMujeer(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaMujeerActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickDuaeNudbah(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaNudbahActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickDuaeArafah(View view) {
        Intent intent = new Intent();
        intent.setClass(DuasActivity.this, DuaArafahActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
