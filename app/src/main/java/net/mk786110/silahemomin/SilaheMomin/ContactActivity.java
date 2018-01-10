package net.mk786110.silahemomin.SilaheMomin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import net.mk786110.silahemomin.Constant.C;
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

public class ContactActivity extends AppCompatActivity {

    EditText mName;
    EditText mMessage;

    String strName = "";
    String strMessage = "";
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.contactLayout));


        mName = (EditText) findViewById(R.id.contact_name_editText);
        mMessage = (EditText) findViewById(R.id.contact_message_editText);

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public void onClick_Contact(View view)

    {
        strName = mName.getText().toString();
        strMessage=mMessage.getText().toString();

            if (strName.length() > -0  && strMessage.length() > -0)
            {
                if(isNetworkConnected()) {
                    new asyncTask_ContactUs().execute();
                }
                else
                {
                    errorMessage("Please Check Internet connection");
                }

        }
            else {
                errorMessage("Please Fill All The Fields");
            }



    }

    public void errorMessage(String Errormessage)
    {
        Toast.makeText(ContactActivity.this,Errormessage , Toast.LENGTH_SHORT).show();

    }

    private class asyncTask_ContactUs extends AsyncTask<Void, Void, String> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog= ProgressDialog.show(ContactActivity.this, "Sending...", C.Salwat, true);

            super.onPreExecute();
        }
        @Override
        protected String doInBackground(Void... params) {
            String msg = "";
            try {
                if (strName.length() > -0  && strMessage.length() > -0) {


                    msg = sendMessageToWebServer(strName,strMessage);

                }
            } catch (Exception ex) {
                msg = "Error :" + ex.getMessage();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
            mName.setText("");
            mMessage.setText("");
            errorMessage("Thanks . Your Message Has been Submitted");

            // full scren ad
            mInterstitialAd = new InterstitialAd(getBaseContext());
            mInterstitialAd.setAdUnitId("ca-app-pub-2985848238387199/3946588264");
            AdRequest adRequestf = new AdRequest.Builder().build();

            // Load ads into Interstitial Ads
            mInterstitialAd.loadAd(adRequestf);

            mInterstitialAd.setAdListener(new AdListener() {
                public void onAdLoaded() {
                    showInterstitial();
                }
            });

        }
    }
    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
    public String sendMessageToWebServer(String name,String message) {
        String url = C.ContactUs;
        String strResponse = "No response";
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("name", name));
            nameValuePairs.add(new BasicNameValuePair("message", message));
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
}
