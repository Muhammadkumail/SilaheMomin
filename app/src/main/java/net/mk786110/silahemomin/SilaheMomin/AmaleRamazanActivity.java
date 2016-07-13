package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;



import net.mk786110.silahemomin.R;

import net.mk786110.silahemomin.ViewRamzan.RamzanMunajatActivity;
import net.mk786110.silahemomin.ViewRamzan.RamzanMushtarekaAmalActivity;
import net.mk786110.silahemomin.ViewRamzan.RamzanShabe19Activity;
import net.mk786110.silahemomin.ViewRamzan.RamzanShabe21Activity;
import net.mk786110.silahemomin.ViewRamzan.RamzanShabe23Activity;

public class AmaleRamazanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ramaza);

        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.amalramzanlaayout));
    }

    public void onClickMushtarekAmal(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRamazanActivity.this, RamzanMushtarekaAmalActivity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickShabeUnnis(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRamazanActivity.this, RamzanShabe19Activity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickShabeIkkis(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRamazanActivity.this, RamzanShabe21Activity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickShabeTeyyes(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRamazanActivity.this, RamzanShabe23Activity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    public void onClickRamzanMunajat(View view) {
        Intent intent = new Intent();
        intent.setClass(AmaleRamazanActivity.this, RamzanMunajatActivity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
}
