package net.mk786110.silahemomin.ViewRajab;

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
import net.mk786110.silahemomin.Adaptor.RajabFirstNightAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.DuaIftitahDataSource;
import net.mk786110.silahemomin.Datasource.RajabFirstNightSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class RajabFirstNightActivity extends AppCompatActivity {
    RajabFirstNightSource mRajabFirstNightSource;
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
            progressDialog= ProgressDialog.show(RajabFirstNightActivity.this, "wait", C.Salwat, true);
            arrayList = new ArrayList<>();
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;
            mRajabFirstNightSource = new RajabFirstNightSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mRajabFirstNightSource.getList();

            if(arrayList.size()==0)
            {
                connectionError="Please Check Internet Connection";

                return null;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

if(connectionError.length()!=0) {
    Toast.makeText(RajabFirstNightActivity.this, connectionError, Toast.LENGTH_SHORT).show();
}
else {
    mlistViewDua = (ListView) findViewById(R.id.detail_listview);

    TextView mtextView = (TextView) findViewById(R.id.detail_textview);

    RajabFirstNightAdaptor mRajabFirstNightAdaptor = new RajabFirstNightAdaptor(context, R.layout.activity_row, arrayList);

    mtextView.setText("رجب کی پہلی رات ");

    mlistViewDua.setAdapter(mRajabFirstNightAdaptor);

    super.onPostExecute(result);

    progressDialog.dismiss();
}
        }


    }

}
