package net.mk786110.silahemomin.Constant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;


/**
 * Created by Muhammad kumail on 05/11/2017.
 */

public class SingletonClass {

    private static Typeface arabicfont;
    private static Typeface urdufont;
    private static Intent mintent ;
    private static HelperMethods helperMethods;
    private static SharedPreferences mSharedPreferences;

    public static Typeface getLanguageFontInstance(Context context , String language) {
        if (language.equals("arabic"))
        {
            if (arabicfont == null) {
                arabicfont = Typeface.createFromAsset( context.getApplicationContext().getAssets(),  "me_quran.ttf");
            }
            return arabicfont;
        }
        if (language.equals("urdu"))
        {
            if (urdufont == null) {
                urdufont = Typeface.createFromAsset( context.getApplicationContext().getAssets(),  "jameel_noori_nastaleeq.ttf");
            }
            return urdufont;
        }
        return  null;
    }

    public static Intent getIntentInstance()
    {
        if (mintent==null)
        {
             mintent = new Intent();
        }
        return mintent;
    }

    public static HelperMethods getHelperMethodsInstance()
    {
        if (helperMethods==null)
        {
            helperMethods =new HelperMethods();

        }
        return helperMethods;
    }

    public static SharedPreferences getmSharedPreferencesInstance(Context context)
    {
        if (mSharedPreferences==null)
        {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return mSharedPreferences;
    }

}
