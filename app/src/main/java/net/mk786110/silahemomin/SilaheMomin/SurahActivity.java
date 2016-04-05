package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewSurahs.SurahAnkabutActivity;
import net.mk786110.silahemomin.ViewSurahs.SurahDukhanActivity;
import net.mk786110.silahemomin.ViewSurahs.SurahRoomActivity;

public class SurahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.surahlayout));


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
}
