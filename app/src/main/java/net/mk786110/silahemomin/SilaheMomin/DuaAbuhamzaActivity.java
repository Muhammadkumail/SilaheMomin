package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.startapp.android.publish.StartAppSDK;

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewDuas.DuaAbumhaza1Activity;
import net.mk786110.silahemomin.ViewDuas.DuaAbumhaza2Activity;
import net.mk786110.silahemomin.ViewDuas.DuaAbumhaza3Activity;


public class DuaAbuhamzaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "205588646", true);
        setContentView(R.layout.activity_dua_abuhamza_parts);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.duaabuhamzapartslayout));

    }

    public void onClickAbuhamzaPart1(View view) {
        Intent intent = new Intent();
        intent.setClass(DuaAbuhamzaActivity.this, DuaAbumhaza1Activity.class);
        startActivity(intent);


        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickAbuhamzaPart2(View view) {
        Intent intent = new Intent();
        intent.setClass(DuaAbuhamzaActivity.this, DuaAbumhaza2Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickAbuhamzaPart3(View view) {

        Intent intent = new Intent();
        intent.setClass(DuaAbuhamzaActivity.this, DuaAbumhaza3Activity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
