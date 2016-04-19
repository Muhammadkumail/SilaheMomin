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
import android.util.Log;


import net.mk786110.silahemomin.Model.MyNotification;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.SilaheMomin.ShowMsgActivity;

import java.io.Serializable;


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
        String strnotificaton_id = mBundle.getString("notification_id");

        int NOTIFICATION_ID = Integer.parseInt(strnotificaton_id);

        sendNotification(strMessage, strTtile, NOTIFICATION_ID);
    }

    private void sendNotification(String msg, String title, int nofication_id) {


        MyNotification mnotification = new MyNotification();
        mnotification.setMsg(msg);
        mnotification.setTitle(title);
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
