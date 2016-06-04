package net.mk786110.silahemomin.ViewSurahs;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.mk786110.silahemomin.Adaptor.SurahRehmanAdaptor;
import net.mk786110.silahemomin.Adaptor.SurahYaseenAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.SurahRehmanDataSource;
import net.mk786110.silahemomin.Datasource.SurahYaseenDataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class SurahYaseenActivity extends AppCompatActivity {

    SurahYaseenDataSource mSurahYaseenDataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Context context;
    Boolean bCancelled;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context=this;
        new get_data_AsynchTask().execute();

    }
    DialogInterface.OnCancelListener cancelListener=new DialogInterface.OnCancelListener(){
        @Override
        public void onCancel(DialogInterface arg0){
            bCancelled=true;
            finish();
        }
    };

    private class get_data_AsynchTask extends AsyncTask<Void,Void,Void>
    {
        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            progressDialog= ProgressDialog.show(SurahYaseenActivity.this, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;
            arrayList = new ArrayList<>();
            mSurahYaseenDataSource=new SurahYaseenDataSource(context);

            super.onPreExecute();
        }


        @Override
        protected Void doInBackground(Void... params) {
            arrayList=mSurahYaseenDataSource.getList();

            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            mlistViewDua=(ListView)findViewById(R.id.detail_listview);
            TextView mtextView=(TextView) findViewById(R.id.detail_textview);

            SurahYaseenAdaptor mSurahYaseenAdaptor=new SurahYaseenAdaptor(context,R.layout.activity_row, arrayList);
            mtextView.setText(" سوره یاسین ");

            mlistViewDua.setAdapter(mSurahYaseenAdaptor);

            super.onPostExecute(aVoid);
            progressDialog.dismiss();
        }
    }

}
