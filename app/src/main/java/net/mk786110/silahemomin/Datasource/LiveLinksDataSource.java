package net.mk786110.silahemomin.Datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Contract.DuaKumailContract;
import net.mk786110.silahemomin.Datasource.SilaheMominDBHelper.SilaheMominSQLHelper;
import net.mk786110.silahemomin.JsonParser.DuaParser;
import net.mk786110.silahemomin.JsonParser.LiveLinksParser;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.Model.LiveLinks;

import java.util.ArrayList;


public class LiveLinksDataSource {


    SilaheMominSQLHelper msilaheMominSQLHelper;
    SQLiteDatabase msqLiteDatabase;

    public LiveLinksDataSource(Context context) {
        msilaheMominSQLHelper = new SilaheMominSQLHelper(context);
        msqLiteDatabase = msilaheMominSQLHelper.getWritableDatabase();
    }

    public ArrayList<LiveLinks> getList() {

        LiveLinksParser duaParser = new LiveLinksParser();

        ArrayList<LiveLinks> arrayListLiveData = new ArrayList<>();
        try {
                arrayListLiveData = duaParser.getParseDua(C.youtubeLinks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayListLiveData;
    }
}
