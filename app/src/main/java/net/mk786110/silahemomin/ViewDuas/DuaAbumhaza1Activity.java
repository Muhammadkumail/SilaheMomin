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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import net.mk786110.silahemomin.Adaptor.SilaheMominAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.DuaIAbuHamza1DataSource;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class DuaAbumhaza1Activity extends AppCompatActivity {
    DuaIAbuHamza1DataSource mDuaIAbuHamza1DataSource;
    ArrayList<Dua> arrayList;
    ListView mlistViewDua;
    Context context;
    Boolean bCancelled;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_detail);

        new get_data_AsynchTask().execute();

        mAdView = (AdView) findViewById(R.id.detail_adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView != null) {
            mAdView.destroy();
        }
        super.onDestroy();
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
            progressDialog= ProgressDialog.show(DuaAbumhaza1Activity.this, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled=false;
            arrayList = new ArrayList<>();
            mDuaIAbuHamza1DataSource = new DuaIAbuHamza1DataSource(context);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            arrayList = mDuaIAbuHamza1DataSource.getList();
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
                Toast.makeText(DuaAbumhaza1Activity. this, connectionError, Toast.LENGTH_SHORT).show();
            } else {
                mlistViewDua = (ListView) findViewById(R.id.detail_listview);
                TextView mtextView = (TextView) findViewById(R.id.detail_textview);

                SilaheMominAdaptor mDuaAbuHamza1Adaptor = new SilaheMominAdaptor(context, R.layout.activity_row, arrayList);

                mtextView.setText("حصه اول");

                mlistViewDua.setAdapter(mDuaAbuHamza1Adaptor);

                super.onPostExecute(aVoid);
                progressDialog.dismiss();
            }
        }

    }

}
