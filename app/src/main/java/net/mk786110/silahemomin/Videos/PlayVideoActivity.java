package net.mk786110.silahemomin.Videos;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.analytics.FirebaseAnalytics;

import net.mk786110.silahemomin.Constant.SingletonClass;
import net.mk786110.silahemomin.Model.Majlis;
import net.mk786110.silahemomin.R;

import java.util.ArrayList;

public class PlayVideoActivity extends AppCompatActivity {
    private FirebaseAnalytics mFirebaseAnalytics;
    public static String mUrl ;
    public static String mTopic ;
    WebView videoView;
    TextView topicName;
    TextView molanaName;
    Typeface urdufont;
    private AdView mAdView_three;
    private InterstitialAd mInterstitialAd;


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
        topicName.setTypeface(urdufont);
        topicName.setTextSize(20);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2985848238387199/4823049066");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
            }

            @Override
            public void onAdOpened() {
            }

            @Override
            public void onAdLeftApplication() {
            }

            @Override
            public void onAdClosed() {
            }
        });
        bannerAdds();

    }

    public void bannerAdds() {

        mAdView_three = (AdView) findViewById(R.id.play_video_adView_three);
        AdRequest adRequest_three = new AdRequest.Builder().build();
        mAdView_three.loadAd(adRequest_three);


    }

    @Override
    public void onPause() {
        if (mAdView_three != null) {
            mAdView_three.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView_three != null) {
            mAdView_three.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView_three != null) {
            mAdView_three.destroy();
        }
        super.onDestroy();
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
}
