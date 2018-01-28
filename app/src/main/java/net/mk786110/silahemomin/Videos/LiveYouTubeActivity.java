package net.mk786110.silahemomin;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import net.mk786110.silahemomin.Constant.C;

public class LiveYouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private InterstitialAd mInterstitialAd;
    private AdView mAdView_one;
    private AdView mAdView_two;
    private AdView mAdView_three;

    YouTubePlayerView youTubeView;
    public static String VideoURL;
    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_ziarat_youtube);
         //loadAdds();
      playLiveYoyTube();
    }


   /* @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }
    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();

    }
    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }*/
   public void playLiveYoyTube() {
       String YoutubeAPIKey = this.getString(R.string.YoutubeAPIKey);
       youTubeView = (YouTubePlayerView) findViewById(R.id.youtubePlyer);
       youTubeView.initialize(YoutubeAPIKey, this);
   }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if (!b) {
            youTubePlayer.cueVideo(VideoURL);
        }
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        C.helperMethods.showMessage(C.youTubeFaildToLoad, this);
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };

    public void loadAdds() {
        bannerAdds();
       // fullScreenAdds();
       // rewardAds();
    }

    public void fullScreenAdds() {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-2985848238387199/7766878490");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                mInterstitialAd.show();
            }
        });
    }
    public void rewardAds() {
        MobileAds.initialize(getApplicationContext(), getString(R.string.admmode_live_ziarat_award_id));
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.loadAd(getString(R.string.admmode_live_ziarat_award_id), new AdRequest.Builder().build());
        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                Toast.makeText(getBaseContext(), "Ad loaded.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdOpened() {
                Toast.makeText(getBaseContext(), "Ad opened.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoStarted() {
                Toast.makeText(getBaseContext(), "Ad started.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdClosed() {
                Toast.makeText(getBaseContext(), "Ad closed.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                Toast.makeText(getBaseContext(), "Ad triggered reward.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
                Toast.makeText(getBaseContext(), "Ad left application.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                Toast.makeText(getBaseContext(), "Ad failed to load.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void bannerAdds() {
        mAdView_one = (AdView) findViewById(R.id.live_ziarat_adView_one);
        mAdView_two = (AdView) findViewById(R.id.live_ziarat_adView_two);
        mAdView_three = (AdView) findViewById(R.id.live_ziarat_adView_three);

        AdRequest adRequest_one = new AdRequest.Builder().build();
        AdRequest adRequest_two = new AdRequest.Builder().build();
        AdRequest adRequest_three = new AdRequest.Builder().build();

        mAdView_one.loadAd(adRequest_one);
        mAdView_two.loadAd(adRequest_two);
        mAdView_three.loadAd(adRequest_three);

    }
    public void onclickloadad(View view) {
        if (mRewardedVideoAd.isLoaded()) {
       //     mRewardedVideoAd.show();
        }
    }

}
