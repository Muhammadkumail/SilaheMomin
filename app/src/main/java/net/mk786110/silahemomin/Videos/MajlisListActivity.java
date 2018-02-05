package net.mk786110.silahemomin.Videos;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.squareup.picasso.Picasso;

import net.mk786110.silahemomin.Adaptor.MajlisAdaptor;
import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.MajlisLinksDataSource;
import net.mk786110.silahemomin.Model.Majlis;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class MajlisListActivity extends AppCompatActivity {

    public static String  molanaid;
    public static String mMolanaImageURL;
    public static ImageView mMolImage;
    Boolean bCancelled;
    ListView mlistViewDua;
    ArrayList<Majlis> arrayListLinks;
    MajlisLinksDataSource majlisLinksDataSource;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_majlis_list);
        context=this;

        mMolImage = (ImageView)findViewById(R.id.molana_image);
        Picasso.with(context).load(mMolanaImageURL).into(mMolImage);

        new get_data_AsynchTask().execute();

    }

    DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {
        @Override
        public void onCancel(DialogInterface arg0) {
            bCancelled = true;
            finish();
        }
    };

    private class get_data_AsynchTask extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        String connectionError = "";

        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(context, "wait", C.Salwat, true);
            progressDialog.setCancelable(true);
            progressDialog.setOnCancelListener(cancelListener);
            bCancelled = false;

            arrayListLinks = new ArrayList<>();

            majlisLinksDataSource = new MajlisLinksDataSource(context);

            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {


            arrayListLinks = majlisLinksDataSource.getList(molanaid);

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (arrayListLinks.size() == 0) {
                C.helperMethods.showMessage("Sorry, please try again later.",context);
                progressDialog.dismiss();
            } else {

                mlistViewDua = (ListView) findViewById(R.id.majlis_listview);

                MajlisAdaptor majlisAdaptor = new MajlisAdaptor(context, R.layout.activity_row, arrayListLinks);
                mlistViewDua.setAdapter(majlisAdaptor);
                super.onPostExecute(aVoid);
                progressDialog.dismiss();

                mlistViewDua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                        if (arrayListLinks.get(position).getMajlis_link_type().contains("1"))
                        {
                            LiveYouTubeActivity.VideoURL=arrayListLinks.get(position).getMajlis_link();
                            C.helperMethods.getStartActivity(LiveYouTubeActivity.class, context);
                        }
                        else{
                            PlayVideoActivity.mUrl = arrayListLinks.get(position).getMajlis_link();
                            PlayVideoActivity.mTopic = arrayListLinks.get(position).getMajlis_topic();
                            C.helperMethods.getStartActivity(PlayVideoActivity.class, context);
                        }
                    }}
                );
            }

        }
    }

}
