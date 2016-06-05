package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.startapp.android.publish.StartAppSDK;

import net.mk786110.silahemomin.R;

import net.mk786110.silahemomin.ViewRajab.RajabFirstNightActivity;
import net.mk786110.silahemomin.ViewRajab.RajabMushtarekaAmalActivity;
import net.mk786110.silahemomin.ViewRajab.RajabShabe27Activity;
import net.mk786110.silahemomin.ViewRajab.RajabTeraToPandraActivity;
import net.mk786110.silahemomin.ViewRajab.RajabUmmeDawoodActivity;
import net.mk786110.silahemomin.ViewRajab.RajabZiaratRajabeaActivity;

public class AmaleRajabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "205588646", true);
        setContentView(R.layout.activity_rajab);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.amalrajablaayout));
    }

    public void onClickRajabPheliRat(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRajabActivity.this, RajabFirstNightActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickMushtarekaAmal(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRajabActivity.this, RajabMushtarekaAmalActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickZiratRajabea(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRajabActivity.this, RajabZiaratRajabeaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickTeratoPandra(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRajabActivity.this, RajabTeraToPandraActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickUmmeDawood(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRajabActivity.this, RajabUmmeDawoodActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickRajabShabe27(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRajabActivity.this, RajabShabe27Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }



}
