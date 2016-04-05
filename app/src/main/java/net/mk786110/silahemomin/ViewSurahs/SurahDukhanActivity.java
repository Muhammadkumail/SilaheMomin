package net.mk786110.silahemomin.ViewSurahs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.DuaKumailAdaptor;
import net.mk786110.silahemomin.Adaptor.SurahDukhanAdaptor;
import net.mk786110.silahemomin.Datasource.DuaKumailDataSource;
import net.mk786110.silahemomin.Datasource.SurahDukhanDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class SurahDukhanActivity extends AppCompatActivity {

    SurahDukhanDataSource mduaDukhanDataSource;
    ArrayList<Dua> arrayList;
    Context context;
    ListView mlistViewDua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context=this;

       new get_data_AsyncTask().execute();




    }

    private class get_data_AsyncTask extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog= ProgressDialog.show(SurahDukhanActivity.this, "wait","اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ، وَعَلَى آلِ مُحَمَّدٍ", true);
            arrayList = new ArrayList<>();
            mduaDukhanDataSource = new SurahDukhanDataSource();

            super.onPreExecute();
        }
        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mduaDukhanDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);
            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            SurahDukhanAdaptor mduaDukhanAdaptor = new SurahDukhanAdaptor(context, R.layout.activity_row, arrayList);
            mtextView.setText("سوره دخان  ");

            mlistViewDua.setAdapter(mduaDukhanAdaptor);
            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }


    }

}
