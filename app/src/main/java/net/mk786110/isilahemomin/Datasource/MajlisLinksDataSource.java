package net.mk786110.isilahemomin.Datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import net.mk786110.isilahemomin.Constant.C;
import net.mk786110.isilahemomin.Datasource.SilaheMominDBHelper.SilaheMominSQLHelper;
import net.mk786110.isilahemomin.JsonParser.MajlisLinksParser;
import net.mk786110.isilahemomin.Model.Majlis;

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
                arrayListLiveData = majlisParser.getParseMajlis(C.majlisLinks+molana_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayListLiveData;
    }

    public ArrayList<Majlis> getLiveYouTubeList() {

        MajlisLinksParser majlisParser = new MajlisLinksParser();

        ArrayList<Majlis> arrayListLiveData = new ArrayList<>();
        try {
            arrayListLiveData = majlisParser.getParseMajlis(C.allLiveYoutubeLinks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayListLiveData;
    }
}
