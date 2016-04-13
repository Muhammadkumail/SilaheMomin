package net.mk786110.silahemomin.ViewRamzan;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.RamzanShabe23Adaptor;
import net.mk786110.silahemomin.Adaptor.ShabanMushtarekaAmalAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.RamzanShabe23DataSource;
import net.mk786110.silahemomin.Datasource.ShabanMushtarekaAmalDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class RamzanShabe23Activity extends AppCompatActivity {
    RamzanShabe23DataSource mRamzanShabe23DataSource;
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
            progressDialog= ProgressDialog.show(RamzanShabe23Activity.this, "wait", C.Salwat, true);
            arrayList = new ArrayList<>();
            mRamzanShabe23DataSource = new RamzanShabe23DataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mRamzanShabe23DataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            RamzanShabe23Adaptor mRamzanShabe23Adaptor = new RamzanShabe23Adaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("ئیسویں رات کے اعمال");

            mlistViewDua.setAdapter(mRamzanShabe23Adaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }


    }

}
