package net.mk786110.silahemomin.SilaheMomin;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

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
    EditText mEmail;
    EditText mMessage;

    String strName = "";
    String strEmail = "";
    String strMessage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.contactLayout));


        mName = (EditText) findViewById(R.id.contact_name_editText);
        mEmail = (EditText) findViewById(R.id.contact_email_editText);
        mMessage = (EditText) findViewById(R.id.contact_message_editText);





    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }

    public void onClick_Contact(View view)

    {
        strName = mName.getText().toString();
        strEmail = mEmail.getText().toString();
        strMessage=mMessage.getText().toString();



            if (strName.length() > -0 && strEmail.length() > -0 && strMessage.length() > -0)
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
                if (strName.length() > -0 && strEmail.length() > -0 && strMessage.length() > -0) {


                    msg = sendMessageToWebServer(strName, strEmail,strMessage);

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
            mEmail.setText("");
            mMessage.setText("");
            errorMessage("Thanks . Your Message Has been Submitted");



        }
    }

    public String sendMessageToWebServer(String name, String email,String message) {
        String url = C.ContactUs;
        String strResponse = "No response";
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("name", name));
            nameValuePairs.add(new BasicNameValuePair("email",email));
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
