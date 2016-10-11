package net.mk786110.silahemomin.ViewAza;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.mk786110.silahemomin.Adaptor.AzaAdaptor;
import net.mk786110.silahemomin.Adaptor.DuaArafahAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.DuaArafahDataSource;
import net.mk786110.silahemomin.Datasource.MuharramTisraDinDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class MuharramTisraDinActivity extends AppCompatActivity {

    MuharramTisraDinDataSource mMuharramTisraDinDataSource;
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
        String connectionError="";
        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(MuharramTisraDinActivity.this, "wait", C.Salwat, true);

            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;


            arrayList = new ArrayList<>();

            mMuharramTisraDinDataSource= new MuharramTisraDinDataSource(context);

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {


            arrayList = mMuharramTisraDinDataSource.getList();
            if(arrayList.size()==0)
            {
                connectionError="Please Check Internet Connection";

                return null;
            }


            return null;


        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (connectionError.length() != 0) {
                Toast.makeText(MuharramTisraDinActivity. this, connectionError, Toast.LENGTH_SHORT).show();
            } else {
                mlistViewDua = (ListView) findViewById(R.id.detail_listview);
                TextView mtextView = (TextView) findViewById(R.id.detail_textview);
                AzaAdaptor mAzaAdaptor= new AzaAdaptor(context, R.layout.activity_hadith_row, arrayList);
                mtextView.setText(" ۳ محرم ");
                mlistViewDua.setAdapter(mAzaAdaptor);


                super.onPostExecute(aVoid);
                progressDialog.dismiss();


            }

        }
    }

}
