package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.startapp.android.publish.StartAppSDK;

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewDuas.MakhsusQuraniDuaActivity;


public class QuraniDuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "205588646", true);
        setContentView(R.layout.activity_qurani_dua);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.quranidualaayout));
    }

    public void onClickQuranmdua(View view) {
        Intent intent = new Intent();
        intent.setClass(QuraniDuaActivity.this,MakhsusQuraniDuaActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }



}
