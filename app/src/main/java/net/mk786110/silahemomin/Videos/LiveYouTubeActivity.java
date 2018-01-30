package net.mk786110.silahemomin.Videos;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
import net.mk786110.silahemomin.R;

public class LiveYouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private AdView mAdView_one;


    YouTubePlayerView youTubeView;
    public static String VideoURL;
    private RewardedVideoAd mRewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_ziarat_youtube);
        bannerAdds();
      playLiveYoyTube();
    }

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


    public void bannerAdds() {

        mAdView_one = (AdView) findViewById(R.id.live_ziarat_adView_one);
        AdRequest adRequest_one = new AdRequest.Builder().build();
        mAdView_one.loadAd(adRequest_one);

    }
    @Override
    public void onPause() {
        if (mAdView_one != null) {
            mAdView_one.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mAdView_one != null) {
            mAdView_one.resume();
        }
    }

    @Override
    public void onDestroy() {
        if (mAdView_one != null) {
            mAdView_one.destroy();
        }
        super.onDestroy();
    }
}
