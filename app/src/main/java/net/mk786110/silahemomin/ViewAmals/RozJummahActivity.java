package net.mk786110.silahemomin.ViewAmals;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.RozJummahAdaptor;
import net.mk786110.silahemomin.Adaptor.ShabeJummahAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.RozJummahDataSource;
import net.mk786110.silahemomin.Datasource.ShabeJummahDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class RozJummahActivity extends AppCompatActivity {
    RozJummahDataSource mRozJummahDataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Context context;
    Boolean bCancelled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_detail);

        new get_data_AsynchTask().execute();

    }


    DialogInterface.OnCancelListener cancelListener=new DialogInterface.OnCancelListener(){
        @Override
        public void onCancel(DialogInterface arg0){
            bCancelled=true;
            finish();
        }
    };

    private class get_data_AsynchTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog;


        @Override
        protected void onPreExecute() {
            progressDialog= ProgressDialog.show(RozJummahActivity.this, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;
            arrayList = new ArrayList<>();
            mRozJummahDataSource = new RozJummahDataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mRozJummahDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            RozJummahAdaptor mRozJummahAdaptor = new RozJummahAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("اعمال شب جمعہ");

            mlistViewDua.setAdapter(mRozJummahAdaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }


    }

}
