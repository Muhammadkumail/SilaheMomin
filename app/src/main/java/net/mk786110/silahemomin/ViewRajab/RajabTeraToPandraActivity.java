package net.mk786110.silahemomin.ViewRajab;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.DuaIftitahAdaptor;
import net.mk786110.silahemomin.Adaptor.RajabTeratoPandraAmalAdaptor;
import net.mk786110.silahemomin.Datasource.DuaIftitahDataSource;
import net.mk786110.silahemomin.Datasource.RajabTeratoPandraDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class RajabTeraToPandraActivity extends AppCompatActivity {
    RajabTeratoPandraDataSource mRajabTeratoPandraDataSource;
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
            progressDialog= ProgressDialog.show(RajabTeraToPandraActivity.this, "wait", "اللَّهُمَّ صَلِّ عَلَى مُحَمَّدٍ، وَعَلَى آلِ مُحَمَّدٍ", true);
            arrayList = new ArrayList<>();
            mRajabTeratoPandraDataSource = new RajabTeratoPandraDataSource();
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mRajabTeratoPandraDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            RajabTeratoPandraAmalAdaptor mRajabTeratoPandraAmalAdaptor = new RajabTeratoPandraAmalAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("۱۳ سے ۱۵ رج تک کے مخصوص اعمال");

            mlistViewDua.setAdapter(mRajabTeratoPandraAmalAdaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }


    }

}
