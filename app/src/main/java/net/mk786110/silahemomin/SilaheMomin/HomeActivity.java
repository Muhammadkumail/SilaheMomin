package net.mk786110.silahemomin.SilaheMomin;


import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

import net.mk786110.silahemomin.Adaptor.HadithAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.HadithDataSource;
import net.mk786110.silahemomin.Model.Hadith;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.Http.MyHttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {


    HadithDataSource mhadithDataSource;
    ArrayList<Hadith> arrayList;
    ListView mlistViewHadith;
    GoogleCloudMessaging gcm;
    String gcmId = "";
    String sender_id = "911030489741";
    String possibleEmail = "";
    Context context;
    String strGcmId="";
    SharedPreferences mSharedPreferences;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        context = this;
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);




        try {
            Account[] accounts = AccountManager.get(this).getAccountsByType("com.google");

            for (Account account : accounts) {

                possibleEmail = account.name;
            }
        } catch (Exception e) {
            Log.i("Exception", "Exception:" + e);
        }

        new get_data_Hadith_AsynchTask().execute();


        if (checkPreferences()==true) {


            if (gcmId.length() == 0) {
                new asyncTask_RegisterGCM().execute();
            }
            new asyncTask_RegisterWeb().execute();

        }
        else {
            Toast.makeText(HomeActivity.this, "السلام علیکم", Toast.LENGTH_SHORT).show();

        }

    }



    private Boolean checkPreferences() {
        strGcmId = mSharedPreferences.getString("key_gcmId", "");

        if (strGcmId.length()==0) {
            return true;
        }
        return false;
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

    public void onClickQuraniDua(View view) {

        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, QuraniDuaActivity.class);
        startActivity(mintent);
    }

    public void onClickMukhtalifAmal(View view) {

        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, MukhtalifAmalActivity.class);
        startActivity(mintent);
    }
    public void onClickContactUs(View view) {

        Intent mintent = new Intent();
        mintent.setClass(HomeActivity.this, ContactActivity.class);
        startActivity(mintent);
    }



    private class asyncTask_RegisterGCM extends AsyncTask<Void, Void, String> {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        @Override
        protected String doInBackground(Void... params) {
            try {

                gcm = GoogleCloudMessaging.getInstance(context);
                gcmId = gcm.register(sender_id);
                editor.putString("key_gcmId", gcmId.toString());
                editor.commit();

            } catch (IOException ex) {
                return "Error:" + ex.getMessage();
            }
            return gcmId;
        }

    }

    private class asyncTask_RegisterWeb extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String msg = "";
            try {
                if (gcmId.length() > -0) {


                        msg = registerDeviceToWebServer(gcmId, possibleEmail);

                }
            } catch (Exception ex) {
                msg = "Error :" + ex.getMessage();
            }
            return msg;
        }

    }

    public String registerDeviceToWebServer(String gcmId, String possibleEmail) {
        String url = C.DeviceRegister;
        String strResponse = "No response";
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("device_gcm_id", gcmId));
            nameValuePairs.add(new BasicNameValuePair("device_type", "1"));
            nameValuePairs.add(new BasicNameValuePair("device_email_address", possibleEmail));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            strResponse = EntityUtils.toString(response.getEntity());
        } catch (ClientProtocolException e) {
            strResponse = e.getMessage();
        } catch (IOException e) {
            Log.e("IOException:", e.getMessage());
            strResponse = e.getMessage();
        }
        return strResponse;
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

            mlistViewHadith = (ListView) findViewById(R.id.home_hadith_listview);
            HadithAdaptor mhadithAdaptor = new HadithAdaptor(context, R.layout.activity_row, arrayList);
            mlistViewHadith.setAdapter(mhadithAdaptor);
            super.onPostExecute(aVoid);
        }
    }


}
