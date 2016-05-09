package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewDuas.MakhsusQuraniDuaActivity;
import net.mk786110.silahemomin.ViewRajab.RajabFirstNightActivity;
import net.mk786110.silahemomin.ViewRajab.RajabMushtarekaAmalActivity;
import net.mk786110.silahemomin.ViewRajab.RajabShabe27Activity;
import net.mk786110.silahemomin.ViewRajab.RajabTeraToPandraActivity;
import net.mk786110.silahemomin.ViewRajab.RajabUmmeDawoodActivity;
import net.mk786110.silahemomin.ViewRajab.RajabZiaratRajabeaActivity;

public class QuraniDuaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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