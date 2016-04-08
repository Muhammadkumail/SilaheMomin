package net.mk786110.silahemomin.ViewShaban;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.RajabFirstNightAdaptor;
import net.mk786110.silahemomin.Adaptor.ShabanNimeShabanAdaptor;
import net.mk786110.silahemomin.Datasource.RajabFirstNightSource;
import net.mk786110.silahemomin.Datasource.ShabanNimeShabanDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class ShabanNimeShabanActivity extends AppCompatActivity {
    ShabanNimeShabanDataSource mShabanNimeShabanDataSource;
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
            progressDialog= ProgressDialog.show(ShabanNimeShabanActivity.this, "wait", "اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ، وَعَلَى آلِ مُحَمَّدٍ", true);
            arrayList = new ArrayList<>();
            mShabanNimeShabanDataSource = new ShabanNimeShabanDataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mShabanNimeShabanDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            ShabanNimeShabanAdaptor mShabanNimeShabanAdaptor = new ShabanNimeShabanAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("اعمال نیمہ شعبان");

            mlistViewDua.setAdapter(mShabanNimeShabanAdaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }


    }

}
