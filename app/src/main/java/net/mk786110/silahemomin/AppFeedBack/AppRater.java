package net.mk786110.silahemomin.AppFeedBack;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.mk786110.silahemomin.Constant.SingletonClass;
import net.mk786110.silahemomin.R;

/**
 * Created by mkumailk on 2/4/18.
 */

public class AppRater {
    private final static String APP_TITLE = "Silahe Momin";// App Name
    private final static String APP_PNAME = "net.mk786110.silahemomin";// Package Name

    private final static int DAYS_UNTIL_PROMPT = 1;//Min number of days
    private final static int LAUNCHES_UNTIL_PROMPT = 1;//Min number of launches

    public static void app_launched(Context mContext) {
        SharedPreferences prefs = mContext.getSharedPreferences("apprater", 0);
        SharedPreferences.Editor editor = prefs.edit();

        // Increment launch counter
        long launch_count = prefs.getLong("launch_count", 0) + 1;
        editor.putLong("launch_count", launch_count);

        // Get date of first launch
        Long date_firstLaunch = prefs.getLong("date_firstlaunch", 0);
        if (date_firstLaunch == 0) {
            date_firstLaunch = System.currentTimeMillis();
            editor.putLong("date_firstlaunch", date_firstLaunch);
        }

        // Wait at least n days before opening
       // if (launch_count >= LAUNCHES_UNTIL_PROMPT) {
         //   if (System.currentTimeMillis() >= date_firstLaunch +
           //         (DAYS_UNTIL_PROMPT * 24 * 60 * 60 * 1000)) {
                showRateDialog(mContext, editor);
           // }
        //}

        editor.commit();
    }

    public static void showRateDialog(final Context mContext, final SharedPreferences.Editor editor) {
        AlertDialog.Builder adb = new AlertDialog.Builder(mContext);
        adb.setTitle("Rate " + APP_TITLE + " App");
        adb.setMessage("If you are satisfied with using " + APP_TITLE + " App kindly share your valuable feedback on play store.");
        adb.setIcon(R.drawable.icon);


        adb.setPositiveButton("Rate Now", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + APP_PNAME)));
                dialog.dismiss();
            } });
        adb.setNegativeButton("Remind Me later", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            } });

        adb.show();
    }
}
