package net.mk786110.silahemomin.SilaheMomin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import net.mk786110.silahemomin.Model.MyNotification;
import net.mk786110.silahemomin.R;

public class ShowMsgActivity extends AppCompatActivity {

    MyNotification myNotification = new MyNotification();

    String activity_english_part="";
    String activity_urdu_part="";
    String activity_pakageName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_msg);
        Intent myIntent = getIntent();
        myNotification = (MyNotification) myIntent.getSerializableExtra("mynotification");

        TextView notification_title = (TextView) findViewById(R.id.show_msg_title);
        TextView notification_msg = (TextView) findViewById(R.id.show_msg_content);
        Button  notification_activity_button=(Button) findViewById(R.id.show_msg_activityButton);

        notification_activity_button.setVisibility(View.GONE);

        activity_english_part=myNotification.getActivity_english_part();
        activity_urdu_part=myNotification.getActivity_urdu_part();
        activity_pakageName=myNotification.getActivity_pakage_name();

        notification_title.setText(myNotification.getTitle());
        notification_msg.setText(myNotification.getMsg());

        if (activity_english_part.length()!=0)
        {
            notification_activity_button.setText(activity_urdu_part);
            notification_activity_button.setVisibility(View.VISIBLE);

        }




    }
    public void activityName_onclick(View view)
    {
        Class<?> c = null;
        if(activity_english_part != null) {
            try {
                c = Class.forName("net.mk786110.silahemomin."+activity_pakageName+"."+activity_english_part );
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Intent intent = new Intent(ShowMsgActivity.this, c);
        startActivity(intent);
    }

    @Override
    protected void onPause() {

        super.onPause();
        finish();
    }
}
