package net.mk786110.silahemomin.ViewDuas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.DuaKumailAdaptor;
import net.mk786110.silahemomin.Datasource.DuaKumailDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DuaKumailActivity extends AppCompatActivity {

    DuaKumailDataSource mduaKumailDataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Context context;
    CheckBox checkBox;
    TextView urdutextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_detail);

        new get_data_AsynchTask().execute();

    }
   

    private class get_data_AsynchTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {

            progressDialog= ProgressDialog.show(DuaKumailActivity.this, "wait","اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ، وَعَلَى آلِ مُحَمَّدٍ", true);

            arrayList = new ArrayList<>();

            mduaKumailDataSource = new DuaKumailDataSource();

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {

            arrayList = mduaKumailDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);
            TextView mtextView = (TextView) findViewById(R.id.detail_textview);
            DuaKumailAdaptor mduaKumailAdaptor = new DuaKumailAdaptor(context, R.layout.activity_hadith_row, arrayList);
            mtextView.setText(" دعای کمیل");
            mlistViewDua.setAdapter(mduaKumailAdaptor);


            super.onPostExecute(aVoid);
            progressDialog.dismiss();


        }


    }

}
