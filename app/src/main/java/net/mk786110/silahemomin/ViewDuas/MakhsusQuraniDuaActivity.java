package net.mk786110.silahemomin.ViewDuas;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
            progressDialog= ProgressDialog.show(MakhsusQuraniDuaActivity.this, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;
            arrayList = new ArrayList<>();
            mQuraniDuaDataSource = new QuraniDuaDataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mQuraniDuaDataSource.getList();
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
                Toast.makeText(MakhsusQuraniDuaActivity.this, connectionError, Toast.LENGTH_SHORT).show();
            } else {
            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            QuraniDuaAdaptor mQuraniDuaAdaptor = new QuraniDuaAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("قرآن میں بیان شدہ دعائیں");
            mtextView.setTextSize(15);

            mlistViewDua.setAdapter(mQuraniDuaAdaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }}


    }

}
