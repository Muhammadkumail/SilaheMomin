package net.mk786110.silahemomin.SilaheMomin;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.google.android.gms.ads.MobileAds;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Constant.SingletonClass;
import net.mk786110.silahemomin.Datasource.HadithDataSource;
import net.mk786110.silahemomin.Datasource.MajlisLinksDataSource;
import net.mk786110.silahemomin.Model.Majlis;
import net.mk786110.silahemomin.Videos.LiveYouTubeActivity;
import net.mk786110.silahemomin.Videos.MajlisActivity;
import net.mk786110.silahemomin.Model.Hadith;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    HadithDataSource mhadithDataSource;
    MajlisLinksDataSource majlisLinksDataSource;
    ArrayList<Hadith> arrayList;
    ArrayList<Majlis> arrayListLinks;

    Context context;
    Boolean bCancelled;
    SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;
        mSharedPreferences = SingletonClass.getmSharedPreferencesInstance(context);
        MobileAds.initialize(this, "ca-app-pub-2985848238387199~3346315866");

        if (C.helperMethods.isNetworkConnected(this))
        {
            new get_liveYoutube_AsynchTask().execute();
            C.helperMethods.showMessage(C.AssalamuAlikum, context);
        }


    }

    public void onClickDuas(View view) {
        C.helperMethods.getStartActivity(DuasActivity.class, this);
    }

    public void onClickziarat(View view) {
        C.helperMethods.getStartActivity(ZiaratActivity.class, this);
    }

    public void onClickMuntakhibSurah(View view) {
        C.helperMethods.getStartActivity(SurahActivity.class, this);
    }

    public void onClickRamazan(View view) {
        C.helperMethods.getStartActivity(AmaleRamazanActivity.class, this);
    }

    public void onClickShaban(View view) {
        C.helperMethods.getStartActivity(AmaleShabanActivity.class, this);
    }

    public void onClickRajab(View view) {
        C.helperMethods.getStartActivity(AmaleRajabActivity.class, this);
    }

    public void onClickQuraniDua(View view) {
        C.helperMethods.getStartActivity(QuraniDuaActivity.class, this);
    }

    public void onClickMukhtalifAmal(View view) {
        C.helperMethods.getStartActivity(MukhtalifAmalActivity.class, this);
    }

    public void onClickAZA(View view) {
        C.helperMethods.getStartActivity(AzaActivity.class, this);
    }

    public void onClickContactUs(View view) {
        C.helperMethods.getStartActivity(ContactActivity.class, this);
    }

    public void onclickliveKarbala(View view) {
        if (C.helperMethods.isNetworkConnected(this)) {
            LiveYouTubeActivity.VideoURL=arrayListLinks.get(4).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,this);
        }
    }

    public void onclickNajaf(View view) {
        if (C.helperMethods.isNetworkConnected(this)) {
            LiveYouTubeActivity.VideoURL = arrayListLinks.get(0).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,this);
        }
    }

    public void onclickMakka(View view) {
        if (C.helperMethods.isNetworkConnected(this)) {
            LiveYouTubeActivity.VideoURL = arrayListLinks.get(3).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,this);
        }
    }

    public void onclickMadinah(View view) {
        if (C.helperMethods.isNetworkConnected(this)) {
            LiveYouTubeActivity.VideoURL = arrayListLinks.get(2).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,this);
        }
    }

    public void onclickKazmain(View view) {
        if (C.helperMethods.isNetworkConnected(this)) {
            LiveYouTubeActivity.VideoURL = arrayListLinks.get(1).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,this);
        }
    }
    public void onclickliveMajlis(View view)
    {
        C.helperMethods.getStartActivity(MajlisActivity.class,this);
    }

    private class get_data_Hadith_AsynchTask extends AsyncTask<Void, Void, Void> {

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
/*
            mlistViewHadith = (ListView) findViewById(R.id.home_hadith_listview);
            SilaheMominAdaptor mhadithAdaptor = new SilaheMominAdaptor(context, R.layout.activity_row, arrayList);
            mlistViewHadith.setAdapter(mhadithAdaptor);*/
            super.onPostExecute(aVoid);
        }
    }

    DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface arg0) {
            bCancelled = true;
            finish();
        }
    };

    private class get_liveYoutube_AsynchTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        String connectionError = "";

        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(context, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled = false;

            arrayListLinks = new ArrayList<>();

            majlisLinksDataSource = new MajlisLinksDataSource(context);

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            arrayListLinks = majlisLinksDataSource.getLiveYouTubeList();
            if (arrayListLinks.size() == 0) {
                connectionError = "Please Check Internet Connection";
                progressDialog.dismiss();
                return null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (connectionError.length() != 0) {
                C.helperMethods.showMessage(connectionError, context);
            } else {
                super.onPostExecute(aVoid);
                progressDialog.dismiss();
            }

        }
    }


}
