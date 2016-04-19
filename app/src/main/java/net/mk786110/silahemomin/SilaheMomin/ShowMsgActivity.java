package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import net.mk786110.silahemomin.Model.MyNotification;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.ViewZiarats.ZiaratAshuraActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratHazratAbbasActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratHazratAliIbnHussainActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratImamHussainActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratSayerShohadaActivity;
import net.mk786110.silahemomin.ViewZiarats.ZiaratWarisActivity;

public class ShowMsgActivity extends AppCompatActivity {

    MyNotification myNotification = new MyNotification();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_msg);
        Intent myIntent = getIntent();

        myNotification = (MyNotification) myIntent.getSerializableExtra("mynotification");

        TextView notification_title = (TextView) findViewById(R.id.show_msg_title);
        TextView notification_msg = (TextView) findViewById(R.id.show_msg_content);

        notification_title.setText(myNotification.getTitle());

        notification_msg.setText(myNotification.getMsg());

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        finish();
    }


}
