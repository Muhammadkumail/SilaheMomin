package net.mk786110.isilahemomin.Datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import net.mk786110.isilahemomin.Constant.C;
import net.mk786110.isilahemomin.Datasource.SilaheMominDBHelper.SilaheMominSQLHelper;
import net.mk786110.isilahemomin.JsonParser.MolanaParserParser;
import net.mk786110.isilahemomin.Model.Album;

import java.util.ArrayList;


public class AllMolanasDataSource {


    SilaheMominSQLHelper msilaheMominSQLHelper;
    SQLiteDatabase msqLiteDatabase;

    public AllMolanasDataSource(Context context) {
        msilaheMominSQLHelper = new SilaheMominSQLHelper(context);
        msqLiteDatabase = msilaheMominSQLHelper.getWritableDatabase();
    }

    public ArrayList<Album> getList() {

        MolanaParserParser molanaParserParser = new MolanaParserParser();

        ArrayList<Album> arrayListLiveData = new ArrayList<>();
        try {
                arrayListLiveData = molanaParserParser.getParseDua(C.allMolanas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayListLiveData;
    }
}
