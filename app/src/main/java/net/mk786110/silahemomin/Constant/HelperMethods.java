package net.mk786110.silahemomin.Constant;


import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import net.mk786110.silahemomin.R;
import net.mk786110.silahemomin.SilaheMomin.HomeActivity;

/**
 * Created by Muhammad kumail on 10/11/2017.
 */

public class HelperMethods  extends AppCompatActivity{

    public void getStartActivity ( Class<?> cls , Context context)
    {
        C.mintent.setClass(context, cls);
        context.startActivity(C.mintent);
    }
    public  void showMessage(String msg,Context context)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
