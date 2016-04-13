package net.mk786110.silahemomin.ViewShaban;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.RajabFirstNightAdaptor;
import net.mk786110.silahemomin.Adaptor.ShabanThirdNightAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.RajabFirstNightSource;
import net.mk786110.silahemomin.Datasource.ShabanThirdNightDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class ShabanThirdNightActivity extends AppCompatActivity {
    ShabanThirdNightDataSource mShabanThirdNightDataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_detail);

        new get_data_AsynchTask().execute();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    private class get_data_AsynchTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog;


        @Override
        protected void onPreExecute() {
            progressDialog= ProgressDialog.show(ShabanThirdNightActivity.this, "wait", C.Salwat, true);
            arrayList = new ArrayList<>();
            mShabanThirdNightDataSource = new ShabanThirdNightDataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mShabanThirdNightDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            ShabanThirdNightAdaptor mShabanThirdNightAdaptor = new ShabanThirdNightAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("تیسری شعبان کا دن");

            mlistViewDua.setAdapter(mShabanThirdNightAdaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }


    }

}
