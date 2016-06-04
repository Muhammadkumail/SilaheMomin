package net.mk786110.silahemomin.service;


import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;



import net.mk786110.silahemomin.Model.MyNotification;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.SilaheMomin.ShowMsgActivity;




public class GCMService extends IntentService {

    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;


    public GCMService() {
        super("GCMService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {


        Bundle mBundle = intent.getExtras();

        String strTtile = mBundle.getString("title");
        String strMessage = mBundle.getString("m");
        String strActivityEnglish = mBundle.getString("activity_english_part");
        String strActivityUrdu = mBundle.getString("activity_urdu_part");
        String strActivityPakageName = mBundle.getString("activity_pakage_name");
       // String strImageUrl=mBundle.getString("image_url");
        String strnotificaton_id = mBundle.getString("notification_id");


        int NOTIFICATION_ID = Integer.parseInt(strnotificaton_id);

        sendNotification(strMessage, strTtile, NOTIFICATION_ID,strActivityEnglish,strActivityUrdu,strActivityPakageName/*,strImageUrl*/);
    }

    private void sendNotification(String msg, String title, int nofication_id,String activity_english_part,String activity_urdu_part,String activity_pakage_name/*, String imageUrl*/) {


        MyNotification mnotification = new MyNotification();
        mnotification.setMsg(msg);
        mnotification.setTitle(title);
        mnotification.setActivity_english_part(activity_english_part);
        mnotification.setActivity_urdu_part(activity_urdu_part);
        mnotification.setActivity_pakage_name(activity_pakage_name);
     //   mnotification.setImage_url(imageUrl);

        Intent mintent = new Intent(this, ShowMsgActivity.class);
        mintent.putExtra("mynotification", mnotification);
        mintent.setAction(Long.toString(System.currentTimeMillis()));

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, mintent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                .setSound(uri).setContentText(msg)
                .setAutoCancel(true);
        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(nofication_id, mBuilder.build());

    }


}
