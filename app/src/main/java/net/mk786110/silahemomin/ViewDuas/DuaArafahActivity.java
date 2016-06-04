package net.mk786110.silahemomin.ViewDuas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.DuaArafahAdaptor;
import net.mk786110.silahemomin.Adaptor.DuaNudbahAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.DuaArafahDataSource;
import net.mk786110.silahemomin.Datasource.DuaNudbahDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class DuaArafahActivity extends AppCompatActivity {

    DuaArafahDataSource mDuaArafahDataSource;
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

            progressDialog = ProgressDialog.show(DuaArafahActivity.this, "wait", C.Salwat, true);

            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;


            arrayList = new ArrayList<>();

            mDuaArafahDataSource = new DuaArafahDataSource(context);

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {


            arrayList = mDuaArafahDataSource.getList();


            return null;


        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);
            TextView mtextView = (TextView) findViewById(R.id.detail_textview);
            DuaArafahAdaptor mDuaArafahAdaptor = new DuaArafahAdaptor(context, R.layout.activity_hadith_row, arrayList);
            mtextView.setText(" دعای عرفہ");
            mlistViewDua.setAdapter(mDuaArafahAdaptor);


            super.onPostExecute(aVoid);
            progressDialog.dismiss();


        }


    }

}
