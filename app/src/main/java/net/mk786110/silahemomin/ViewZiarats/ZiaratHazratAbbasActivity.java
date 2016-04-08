package net.mk786110.silahemomin.ViewZiarats;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.SurahAnkabutAdaptor;
import net.mk786110.silahemomin.Adaptor.ZiaratHazratAbbasAdaptor;
import net.mk786110.silahemomin.Datasource.SurahAnkabutDataSource;
import net.mk786110.silahemomin.Datasource.ZiaratHazratAbbasDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class ZiaratHazratAbbasActivity extends AppCompatActivity {

    ZiaratHazratAbbasDataSource mziaratHazratAbbasDataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context=this;
        new get_data_AsynchTask().execute();

    }

    private class get_data_AsynchTask extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog= ProgressDialog.show(ZiaratHazratAbbasActivity.this, "wait","اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ، وَعَلَى آلِ مُحَمَّدٍ", true);
            arrayList = new ArrayList<>();
            mziaratHazratAbbasDataSource=new ZiaratHazratAbbasDataSource(context);

            super.onPreExecute();
        }


        @Override
        protected Void doInBackground(Void... params) {
            arrayList=mziaratHazratAbbasDataSource.getList();

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            mlistViewDua=(ListView)findViewById(R.id.detail_listview);
            TextView mtextView=(TextView) findViewById(R.id.detail_textview);

            ZiaratHazratAbbasAdaptor mziaratHazratAbbasAdaptor=new ZiaratHazratAbbasAdaptor(context,R.layout.activity_row, arrayList);
            mtextView.setText("زیارت حضرت عباس بن امیرالمومنین");
            mtextView.setTextSize(16);
            mtextView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
            mlistViewDua.setAdapter(mziaratHazratAbbasAdaptor);

            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }
    }

}
