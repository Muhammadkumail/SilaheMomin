package net.mk786110.silahemomin.Datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Datasource.SilaheMominDBHelper.SilaheMominSQLHelper;
import net.mk786110.silahemomin.JsonParser.LiveLinksParser;
import net.mk786110.silahemomin.JsonParser.MajlisLinksParser;
import net.mk786110.silahemomin.Model.LiveLinks;
import net.mk786110.silahemomin.Model.Majlis;

import java.util.ArrayList;


public class MajlisLinksDataSource {


    SilaheMominSQLHelper msilaheMominSQLHelper;
    SQLiteDatabase msqLiteDatabase;

    public MajlisLinksDataSource(Context context) {
        msilaheMominSQLHelper = new SilaheMominSQLHelper(context);
        msqLiteDatabase = msilaheMominSQLHelper.getWritableDatabase();
    }

    public ArrayList<Majlis> getList(String molana_id) {

        MajlisLinksParser majlisParser = new MajlisLinksParser();

        ArrayList<Majlis> arrayListLiveData = new ArrayList<>();
        try {
                arrayListLiveData = majlisParser.getParseDua(C.majlisLinks+molana_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayListLiveData;
    }
}
