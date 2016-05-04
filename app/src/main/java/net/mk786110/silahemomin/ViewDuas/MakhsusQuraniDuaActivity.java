package net.mk786110.silahemomin.ViewDuas;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.DuaIftitahAdaptor;
import net.mk786110.silahemomin.Adaptor.QuraniDuaAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.DuaIftitahDataSource;
import net.mk786110.silahemomin.Datasource.QuraniDuaDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class MakhsusQuraniDuaActivity extends AppCompatActivity {
    QuraniDuaDataSource mQuraniDuaDataSource;
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
            progressDialog= ProgressDialog.show(MakhsusQuraniDuaActivity.this, "wait", C.Salwat, true);
            arrayList = new ArrayList<>();
            mQuraniDuaDataSource = new QuraniDuaDataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mQuraniDuaDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            QuraniDuaAdaptor mQuraniDuaAdaptor = new QuraniDuaAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("قرآن میں بیان شدہ دعائیں");

            mlistViewDua.setAdapter(mQuraniDuaAdaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }


    }

}
