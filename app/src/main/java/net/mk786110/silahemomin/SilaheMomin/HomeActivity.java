package net.mk786110.silahemomin.SilaheMomin;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import net.mk786110.silahemomin.Adaptor.HadithAdaptor;
import net.mk786110.silahemomin.Datasource.HadithDataSource;
import net.mk786110.silahemomin.Http.MyHttpClient;
import net.mk786110.silahemomin.Model.Hadith;
import net.mk786110.silahemomin.R;

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

    MyHttpClient myHttpClient;
    HadithDataSource mhadithDataSource;
    ArrayList<Hadith> arrayList;
    ListView mlistViewHadith;

    GoogleCloudMessaging gcm;
    String gcmId = "";
    String sender_id = "911030489741";

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;

        new get_data_Hadith_AsynchTask().execute();

        if (gcmId.length() == 0) {
            new asyncTask_RegisterGCM().execute();
        }

        new asyncTask_RegisterWeb().execute();

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

        /*Intent mintent = new Intent();
        // mintent.setClass(HomeActivity.this, AmaleShabeAshurActivity.class);
        startActivity(mintent);*/
    }


    private class asyncTask_RegisterGCM extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            try {
                gcm = GoogleCloudMessaging.getInstance(context);
                gcmId = gcm.register(sender_id);
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
                    msg =registerDeviceToWebServer(gcmId);
                }
            } catch (Exception ex) {
                msg = "Error :" + ex.getMessage();
            }
            return msg;
        }

    }
    public String registerDeviceToWebServer(String gcmId) {
        String url = "http://friendsfashion.net/android/kumail/register.php";
        String strResponse = "No response";
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("device_gcm_id", gcmId));
            nameValuePairs.add(new BasicNameValuePair("device_api_key", ""));
            nameValuePairs.add(new BasicNameValuePair("device_type", "1"));
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
