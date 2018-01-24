package net.mk786110.silahemomin.SilaheMomin;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


import com.google.android.gms.ads.MobileAds;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Constant.SingletonClass;
import net.mk786110.silahemomin.Datasource.AllMolanasDataSource;
import net.mk786110.silahemomin.Datasource.HadithDataSource;
import net.mk786110.silahemomin.Datasource.LiveLinksDataSource;
import net.mk786110.silahemomin.Model.Album;
import net.mk786110.silahemomin.PlayVideoActivity;
import net.mk786110.silahemomin.LiveYouTubeActivity;
import net.mk786110.silahemomin.MajlisActivity;
import net.mk786110.silahemomin.Model.Hadith;
import net.mk786110.silahemomin.Model.LiveLinks;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    HadithDataSource mhadithDataSource;
    LiveLinksDataSource mliveLinksDataSource;
    ArrayList<Hadith> arrayList;
    ArrayList<LiveLinks> arrayListLinks;



    ListView mlistViewHadith;

    String gcmId = "";
    Context context;
    String strGcmId = "";
    Boolean bCancelled;
    SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;
        mSharedPreferences = SingletonClass.getmSharedPreferencesInstance(context);
        MobileAds.initialize(this, "ca-app-pub-2985848238387199~3346315866");

        //new get_data_Hadith_AsynchTask().execute();

        //if (C.helperMethods.isNetworkConnected())
        //{
            //new get_data_AsynchTask().execute();
        //}

        if (checkPreferences() == true) {
            if (gcmId.length() == 0) {
                // new asyncTask_RegisterGCM().execute();
            }
            //new asyncTask_RegisterWeb().execute();
        } else {
            C.helperMethods.showMessage(C.AssalamuAlikum, context);
        }
    }

    private Boolean checkPreferences() {
        strGcmId = mSharedPreferences.getString("key_gcmId", "");

        if (strGcmId.length() == 0) {
            return true;
        }
        return false;
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

    public void onClickSettings(View view) {
        C.helperMethods.getStartActivity(SettingActivity.class, this);
    }

    public void onclickliveKarbala(View view) {
        C.helperMethods.getStartActivity(PlayVideoActivity.class, this);
    }

    public void onclickNajaf(View view) {
        LiveYouTubeActivity.VideoURL=arrayListLinks.get(0).getLink_url();
        C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);

    }

    public void onclickMakka(View view) {
        LiveYouTubeActivity.VideoURL=arrayListLinks.get(3).getLink_url();
        C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
    }

    public void onclickMadinah(View view) {
        LiveYouTubeActivity.VideoURL=arrayListLinks.get(2).getLink_url();
        C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
    }

    public void onclickKazmain(View view) {
        LiveYouTubeActivity.VideoURL=arrayListLinks.get(1).getLink_url();
        C.helperMethods.getStartActivity(LiveYouTubeActivity.class, this);
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

    private class get_data_AsynchTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        String connectionError = "";

        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(context, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled = false;


            arrayListLinks = new ArrayList<>();

            mliveLinksDataSource = new LiveLinksDataSource(context);

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {


            arrayListLinks = mliveLinksDataSource.getList();
            if (arrayListLinks.size() == 0) {
                connectionError = "Please Check Internet Connection";

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
