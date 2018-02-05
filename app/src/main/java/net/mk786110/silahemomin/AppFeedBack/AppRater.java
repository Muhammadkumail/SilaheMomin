package net.mk786110.silahemomin.AppFeedBack;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
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
    private final static String APP_TITLE = "Silahe Momin";
    private final static String APP_PNAME = "net.mk786110.silahemomin";
    public  int launch_count = 0;

    public static void app_launched(Context mContext) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(mContext);
        SharedPreferences.Editor editor = preferences.edit();


        int count = preferences.getInt("appLaunchCount",0);
        if(count<5)
        {

            editor.putInt("appLaunchCount",1);
            editor.commit();
        }


                showRateDialog(mContext, editor);

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
