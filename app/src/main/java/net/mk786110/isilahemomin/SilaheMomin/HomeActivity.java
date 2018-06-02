package net.mk786110.isilahemomin.SilaheMomin;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.google.android.gms.ads.MobileAds;

import net.mk786110.isilahemomin.Constant.C;
import net.mk786110.isilahemomin.Datasource.HadithDataSource;
import net.mk786110.isilahemomin.Datasource.MajlisLinksDataSource;
import net.mk786110.isilahemomin.Model.Majlis;
import net.mk786110.isilahemomin.Videos.LiveYouTubeActivity;
import net.mk786110.isilahemomin.Videos.MajlisActivity;
import net.mk786110.isilahemomin.Model.Hadith;
import net.mk786110.isilahemomin.R;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    HadithDataSource mhadithDataSource;
    MajlisLinksDataSource majlisLinksDataSource;
    ArrayList<Hadith> arrayList;
    ArrayList<Majlis> arrayListLinks;

    Context context;
    Boolean bCancelled;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        context = this;
        //MobileAds.initialize(getApplicationContext(), "ca-app-pub-2985848238387199~3346315866");

        //AppRater.app_launched(this);
        if (C.helperMethods.isNetworkConnected(context))
        {
            new get_liveYoutube_AsynchTask().execute();
            C.helperMethods.showMessage(C.AssalamuAlikum, context);
        }

        /*Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String videoType;
            videoType = extras.getString("videoType");
            if (videoType.contains("1")) {
                LiveYouTubeActivity.VideoURL = extras.getString("link");
                C.helperMethods.getStartActivity(LiveYouTubeActivity.class, context);
            } else {
                PlayVideoActivity.mTopic = extras.getString("topic");
                PlayVideoActivity.mUrl = extras.getString("link");
                C.helperMethods.getStartActivity(PlayVideoActivity.class, context);
            }
        }*/
    }

    public void onClickDuas(View view) {
        C.helperMethods.getStartActivity(DuasActivity.class, context);
    }

    public void onClickziarat(View view) {
        C.helperMethods.getStartActivity(ZiaratActivity.class, context);
    }

    public void onClickMuntakhibSurah(View view) {
        C.helperMethods.getStartActivity(SurahActivity.class, context);
    }

    public void onClickRamazan(View view) {
        C.helperMethods.getStartActivity(AmaleRamazanActivity.class, context);
    }

    public void onClickShaban(View view) {
        C.helperMethods.getStartActivity(AmaleShabanActivity.class, context);
    }

    public void onClickRajab(View view) {
        C.helperMethods.getStartActivity(AmaleRajabActivity.class, context);
    }

    public void onClickQuraniDua(View view) {
        C.helperMethods.getStartActivity(QuraniDuaActivity.class, context);
    }

    public void onClickMukhtalifAmal(View view) {
        C.helperMethods.getStartActivity(MukhtalifAmalActivity.class, context);
    }

    public void onClickAZA(View view) {
        C.helperMethods.getStartActivity(AzaActivity.class, context);
    }

    public void onClickContactUs(View view) {
        C.helperMethods.getStartActivity(ContactActivity.class, context);
    }

    public void onclickliveKarbala(View view) {
        if (C.helperMethods.isNetworkConnected(context)) {
            LiveYouTubeActivity.VideoURL=arrayListLinks.get(4).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, context);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,context);
        }
    }

    public void onclickNajaf(View view) {
        if (C.helperMethods.isNetworkConnected(context)) {
            LiveYouTubeActivity.VideoURL = arrayListLinks.get(0).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, context);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,context);
        }
    }

    public void onclickMakka(View view) {
        if (C.helperMethods.isNetworkConnected(context)) {
            LiveYouTubeActivity.VideoURL = arrayListLinks.get(3).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, context);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,context);
        }
    }

    public void onclickMadinah(View view) {
        if (C.helperMethods.isNetworkConnected(context)) {
            LiveYouTubeActivity.VideoURL = arrayListLinks.get(2).getMajlis_link();
            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, context);
        }
        else {
            C.helperMethods.showMessage(C.plesseCheckInternetConnection,context);
        }
    }

    public void onclickliveMajlis(View view)
    {
        C.helperMethods.getStartActivity(MajlisActivity.class,this);
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
                progressDialog.dismiss();
            } else {
                super.onPostExecute(aVoid);
                progressDialog.dismiss();
            }

        }
    }


}
