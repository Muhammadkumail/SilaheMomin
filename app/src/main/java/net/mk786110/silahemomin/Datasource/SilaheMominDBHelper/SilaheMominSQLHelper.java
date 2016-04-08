package net.mk786110.silahemomin.Datasource.SilaheMominDBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.mk786110.silahemomin.Contract.DuaAbuHamza1Contract;
import net.mk786110.silahemomin.Contract.DuaAbuHamza2Contract;
import net.mk786110.silahemomin.Contract.DuaAbuHamza3Contract;
import net.mk786110.silahemomin.Contract.DuaIftitahContract;
import net.mk786110.silahemomin.Contract.DuaImamZmanaContract;
import net.mk786110.silahemomin.Contract.DuaJoshanKabeerContract;
import net.mk786110.silahemomin.Contract.DuaKumailContract;
import net.mk786110.silahemomin.Contract.DuaTawassulContract;


public class SilaheMominSQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "silahemomin.db";
    public static final int DATABASE_VERSION = 1;

    public SilaheMominSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DuaKumailContract.SQL_CREATE);
        db.execSQL(DuaTawassulContract.SQL_CREATE);
        db.execSQL(DuaIftitahContract.SQL_CREATE);
        db.execSQL(DuaImamZmanaContract.SQL_CREATE);
        db.execSQL(DuaJoshanKabeerContract.SQL_CREATE);
        db.execSQL(DuaAbuHamza1Contract.SQL_CREATE);
        db.execSQL(DuaAbuHamza2Contract.SQL_CREATE);
        db.execSQL(DuaAbuHamza3Contract.SQL_CREATE);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
