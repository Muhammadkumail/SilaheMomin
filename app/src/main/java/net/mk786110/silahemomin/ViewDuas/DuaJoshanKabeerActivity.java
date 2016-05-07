package net.mk786110.silahemomin.ViewDuas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.DuaIftitahAdaptor;
import net.mk786110.silahemomin.Adaptor.DuaJoshanKabeerAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.DuaIftitahDataSource;
import net.mk786110.silahemomin.Datasource.DuaJoshanKabeerDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class DuaJoshanKabeerActivity extends AppCompatActivity {

    Context context;
    DuaJoshanKabeerDataSource mduaJoshanKabeerDataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Boolean bCancelled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context = this;

        new get_data_AsychTask().execute();

    }

    DialogInterface.OnCancelListener cancelListener=new DialogInterface.OnCancelListener(){
        @Override
        public void onCancel(DialogInterface arg0){
            bCancelled=true;
            finish();
        }
    };

    private class get_data_AsychTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog= ProgressDialog.show(DuaJoshanKabeerActivity.this, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;
            arrayList=new ArrayList<>();
            mduaJoshanKabeerDataSource = new DuaJoshanKabeerDataSource(context);

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mduaJoshanKabeerDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            mlistViewDua = (ListView) findViewById(R.id.detail_listview);
            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            DuaJoshanKabeerAdaptor mduaJoshanKabeerAdaptor = new DuaJoshanKabeerAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("دعای جوشن کبیر");

            mlistViewDua.setAdapter(mduaJoshanKabeerAdaptor);


            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }


    }

}
