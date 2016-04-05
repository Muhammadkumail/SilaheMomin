package net.mk786110.silahemomin.SilaheMomin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.BidiFormatter;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.DuaKumailAdaptor;
import net.mk786110.silahemomin.Adaptor.HadithAdaptor;
import net.mk786110.silahemomin.Datasource.DuaKumailDataSource;
import net.mk786110.silahemomin.Datasource.HadithDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.Model.Hadith;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    HadithDataSource mhadithDataSource;
    ArrayList<Hadith> arrayList;
    ListView mlistViewHadith;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;

        new get_data_AsynchTask().execute();

    }

    public void onClickDuas(View view) {
        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, DuasActivity.class);
        startActivity(mintent);


    }

    public void onClickziarat(View view) {
        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, ZiaratActivity.class);
        startActivity(mintent);


    }

    public void onClickMuntakhibSurah(View view) {
        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, SurahActivity.class);
        startActivity(mintent);


    }

    public void onClickRamazan(View view) {
        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, AmaleRamazanActivity.class);
        startActivity(mintent);


    }

    public void onClickShaban(View view) {
        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, AmaleShabanActivity.class);
        startActivity(mintent);

    }

    public void onClickRajab(View view) {
        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, AmaleRajabActivity.class);
        startActivity(mintent);


    }

    public void onClickAmalshabeAshur(View view) {
        Intent mintent = new Intent();
        // mintent.setClass(HomeActivity.this, AmaleShabeAshurActivity.class);
        startActivity(mintent);


    }

    private class get_data_AsynchTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {

            arrayList = new ArrayList<>();

            mhadithDataSource = new HadithDataSource();

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            arrayList = mhadithDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewHadith = (ListView) findViewById(R.id.home_hadith_listview);

            HadithAdaptor mhadithAdaptor = new HadithAdaptor(context, R.layout.activity_row, arrayList);

            mlistViewHadith.setAdapter(mhadithAdaptor);


            super.onPostExecute(aVoid);


        }
    }


}
