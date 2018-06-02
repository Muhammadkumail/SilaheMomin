package net.mk786110.silahemomin.service;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.SilaheMomin.HomeActivity;
import net.mk786110.silahemomin.Videos.LiveYouTubeActivity;
import net.mk786110.silahemomin.Videos.PlayVideoActivity;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class GCMService extends FirebaseMessagingService  {


    private static final String TAG = "FirebaseMessageService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        String message = remoteMessage.getData().get("msg");
        String videoType = remoteMessage.getData().get("type");
        String videolink = remoteMessage.getData().get("link");
        String videoTopic = remoteMessage.getData().get("topic");

        sendNotification(message, videoType,videolink,videoTopic);

    }

    private void sendNotification(String messageBody, String videoType,String videolink,String videoTopic) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("videoType", videoType);
        intent.putExtra("link", videolink);
        intent.putExtra("topic", videoTopic);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setLargeIcon(null)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle(messageBody)
                .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(null))
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }



}
