package net.mk786110.silahemomin.ViewRamzan;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.RamzanMunajatAdaptor;
import net.mk786110.silahemomin.Adaptor.ShabanMushtarekaAmalAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.RamzanMunajatDataSource;
import net.mk786110.silahemomin.Datasource.ShabanMushtarekaAmalDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class RamzanMunajatActivity extends AppCompatActivity {
    RamzanMunajatDataSource mRamzanMunajatDataSource;
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
            progressDialog= ProgressDialog.show(RamzanMunajatActivity.this, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;
            arrayList = new ArrayList<>();
            mRamzanMunajatDataSource = new RamzanMunajatDataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mRamzanMunajatDataSource.getList();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            mlistViewDua = (ListView) findViewById(R.id.detail_listview);

            TextView mtextView = (TextView) findViewById(R.id.detail_textview);

            RamzanMunajatAdaptor mRamzanMunajatAdaptor = new RamzanMunajatAdaptor(context, R.layout.activity_row, arrayList);

            mtextView.setText("مناجات  امیرالمومنین(ع)");

            mlistViewDua.setAdapter(mRamzanMunajatAdaptor);

            super.onPostExecute(aVoid);

            progressDialog.dismiss();
        }


    }

}
