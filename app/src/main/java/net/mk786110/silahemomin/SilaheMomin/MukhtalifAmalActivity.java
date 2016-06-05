package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;
import com.startapp.android.publish.StartAppSDK;

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewAmals.RozEidFitrActivity;
import net.mk786110.silahemomin.ViewAmals.RozJummahActivity;
import net.mk786110.silahemomin.ViewAmals.ShabeEidFitrActivity;
import net.mk786110.silahemomin.ViewAmals.ShabeJummahActivity;


public class MukhtalifAmalActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AdBuddiz.setPublisherKey("88de095c-b0c4-4dbc-925a-9649b11d08fb");
        AdBuddiz.cacheAds(this);
        AdBuddiz.showAd(this);
        StartAppSDK.init(this, "205588646", true);
        setContentView(R.layout.activity_mukhtali_amal);
        YoYo.with(Techniques.DropOut)
                .duration(1000)
                .playOn(findViewById(R.id.mukhtaliflayout));

    }

    public void onClickShabeJummah(View view) {
        Intent intent = new Intent();
        intent.setClass(MukhtalifAmalActivity.this, ShabeJummahActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickShabeEidFitr(View view) {
        Intent intent = new Intent();
        intent.setClass(MukhtalifAmalActivity.this, ShabeEidFitrActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickRozJummah(View view) {
        Intent intent = new Intent();
        intent.setClass(MukhtalifAmalActivity.this, RozJummahActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }
    public void onClickRozEidFitr(View view) {
        Intent intent = new Intent();
        intent.setClass(MukhtalifAmalActivity.this, RozEidFitrActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }


}
