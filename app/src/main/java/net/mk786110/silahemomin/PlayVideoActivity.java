package net.mk786110.silahemomin;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;

import net.mk786110.silahemomin.Constant.SingletonClass;
import net.mk786110.silahemomin.Model.Majlis;

import java.util.ArrayList;

public class PlayVideoActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    public static String mUrl ;
    public static String mTopic ;
    public static String mMolanaName;
    WebView videoView;
    TextView topicName;
    TextView molanaName;
    Typeface urdufont;
    private AdView mAdView_one;
    private AdView mAdView_two;
    private AdView mAdView_three;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_ziarat);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        urdufont = SingletonClass.getLanguageFontInstance(this, "urdu");
        videoView = (WebView) findViewById(R.id.live_ziarat_webView);
        topicName=(TextView)findViewById(R.id.topic_name);
        molanaName=(TextView)findViewById(R.id.molana_name_textView);


        videoView.loadUrl(mUrl);
        topicName.setText(mTopic);
        //molanaName.setText(mMolanaName);
        //molanaName.setTypeface(urdufont);
        topicName.setTypeface(urdufont);
        topicName.setTextSize(20);
        //molanaName.setTextSize(30);
        Bundle bundle = new Bundle();

        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, mTopic);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, mMolanaName);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "play_islamic_video");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        //bannerAdds();

    }
    @Override
    public void onBackPressed() {
        videoView.stopLoading();
        videoView.removeAllViews();
        videoView.destroy();
        videoView = null;
        topicName.setText("");
        finish();
        super.onBackPressed();
    }

    public void bannerAdds() {
        mAdView_one = (AdView) findViewById(R.id.play_video_adView_one);
        mAdView_two = (AdView) findViewById(R.id.play_video_adView_two);
        mAdView_three = (AdView) findViewById(R.id.play_video_adView_three);

        AdRequest adRequest_one = new AdRequest.Builder().build();
        AdRequest adRequest_two = new AdRequest.Builder().build();
        AdRequest adRequest_three = new AdRequest.Builder().build();


        mAdView_one.loadAd(adRequest_one);
        mAdView_two.loadAd(adRequest_two);
        mAdView_three.loadAd(adRequest_three);

    }
}
