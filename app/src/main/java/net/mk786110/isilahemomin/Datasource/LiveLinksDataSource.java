package net.mk786110.isilahemomin.Datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import net.mk786110.isilahemomin.Constant.C;
import net.mk786110.isilahemomin.Datasource.SilaheMominDBHelper.SilaheMominSQLHelper;
import net.mk786110.isilahemomin.JsonParser.LiveLinksParser;
import net.mk786110.isilahemomin.Model.LiveLinks;

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
                arrayListLiveData = duaParser.getParseDua(C.allLiveYoutubeLinks);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayListLiveData;
    }
}
