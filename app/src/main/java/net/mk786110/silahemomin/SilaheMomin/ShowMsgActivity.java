package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.mk786110.silahemomin.Model.MyNotification;
import net.mk786110.silahemomin.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class ShowMsgActivity extends AppCompatActivity {

    MyNotification myNotification = new MyNotification();

    String activity_english_part = "";
    String activity_urdu_part = "";
    String activity_pakageName = "";
    String titile = "";
    String message = "";

    TextView notification_title;
    TextView notification_msg;

    String app_link = "http://bit.ly/1svpjwg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_msg);

        Intent myIntent = getIntent();
        myNotification = (MyNotification) myIntent.getSerializableExtra("mynotification");
        Button notification_activity_button = (Button) findViewById(R.id.show_msg_activityButton);
        Button share_button = (Button) findViewById(R.id.show_msg_share_button);

        notification_title = (TextView) findViewById(R.id.show_msg_title);
        notification_msg = (TextView) findViewById(R.id.show_msg_content);



        activity_english_part = myNotification.getActivity_english_part();
        activity_urdu_part = myNotification.getActivity_urdu_part();
        activity_pakageName = myNotification.getActivity_pakage_name();



        titile = myNotification.getTitle();
        message = myNotification.getMsg();

        notification_title.setText(titile);
        notification_msg.setMovementMethod(new ScrollingMovementMethod());
        notification_msg.setText(message);



        notification_activity_button.setVisibility(View.GONE);

        if (activity_english_part.length() != 0) {
            notification_activity_button.setText(activity_urdu_part);
            notification_activity_button.setVisibility(View.VISIBLE);
            share_button.setVisibility(View.INVISIBLE);

        }


    }


    public void activityName_onclick(View view) {
        Class<?> c = null;
        if (activity_english_part != null) {
            try {
                c = Class.forName("net.mk786110.silahemomin." + activity_pakageName + "." + activity_english_part);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(ShowMsgActivity.this, c);
        startActivity(intent);
    }

    public void share_onclick(View view) {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, titile + "\n\n" + message + "\n\n" + app_link);
        startActivity(Intent.createChooser(sharingIntent, "Share using"));
    }

    @Override
    protected void onPause() {

        super.onPause();
        finish();
    }
}
