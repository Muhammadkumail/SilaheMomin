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
import net.mk786110.silahemomin.Constant.SingletonClass;
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
    Context context;
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.contactLayout));
        context=this;
        mName = (EditText) findViewById(R.id.contact_name_editText);
        mMessage = (EditText) findViewById(R.id.contact_message_editText);

    }

    public void onClick_Contact(View view)

    {
        strName = mName.getText().toString();
        strMessage=mMessage.getText().toString();

            if (strName.length() > -0  && strMessage.length() > -0)
            {
                if(C.helperMethods.isNetworkConnected(context)) {
                    mInterstitialAd = new InterstitialAd(this);
                    mInterstitialAd.setAdUnitId("ca-app-pub-2985848238387199/4823049066");
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());

                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                                new asyncTask_ContactUs().execute();
                            }
                        }

                        @Override
                        public void onAdFailedToLoad(int errorCode) {
                            new asyncTask_ContactUs().execute();
                        }

                        @Override
                        public void onAdOpened() {
                        }

                        @Override
                        public void onAdLeftApplication() {
                        }

                        @Override
                        public void onAdClosed() {
                        }
                    });

                }
                else
                {
                    C.helperMethods.showMessage(C.plesseCheckInternetConnection,context);
                }

        }
            else {
                C.helperMethods.showMessage("Please Fill All The Fields",context);

            }
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
            C.helperMethods.showMessage("Thanks . Your Message Has been Submitted",context);
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
