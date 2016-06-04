package net.mk786110.silahemomin.Datasource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Contract.RozEidFitrContract;
import net.mk786110.silahemomin.Contract.ShabeEidFitrContract;
import net.mk786110.silahemomin.Contract.ShabeJummahContract;
import net.mk786110.silahemomin.Datasource.SilaheMominDBHelper.SilaheMominSQLHelper;
import net.mk786110.silahemomin.JsonParser.DuaParser;
import net.mk786110.silahemomin.Model.Dua;

import java.util.ArrayList;


public class RozEidFitrDataSource {
    SilaheMominSQLHelper msilaheMominSQLHelper;
    SQLiteDatabase msqLiteDatabase;

    public RozEidFitrDataSource(Context context) {
        msilaheMominSQLHelper = new SilaheMominSQLHelper(context);
        msqLiteDatabase = msilaheMominSQLHelper.getWritableDatabase();
    }

    public ArrayList<Dua> getList() {

        DuaParser duaParser = new DuaParser();
        ArrayList<Dua> arrayListLiveData;
        try {

            ArrayList<Dua> arrayListSqllite = getListFromSQLite();
            if (arrayListSqllite != null && arrayListSqllite.size() > 0) {
                return getListFromSQLite();

            } else {
                arrayListLiveData = duaParser.getParseDua(C.RozFitrJson);
                deleteAll();
                bulkInsert(arrayListLiveData);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return getListFromSQLite();


    }


    public ArrayList<Dua> getListFromSQLite() {
        ArrayList<Dua> arrayList = new ArrayList<>();
        try {
            Cursor mcursor = msqLiteDatabase.rawQuery(RozEidFitrContract.SQL_SELECT_ALL, null);
            while (mcursor.moveToNext()) {
                Dua dua = new Dua();
                dua.setDua_arabic_part(mcursor.getString(mcursor.getColumnIndex(RozEidFitrContract.RozEidFitrEntry.COLUMN_NAME_ARABIC_PART)));
                dua.setDua_urdu_part(mcursor.getString(mcursor.getColumnIndex(RozEidFitrContract.RozEidFitrEntry.COLUMN_NAME_URDU_PART)));
                arrayList.add(dua);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public long insert(Dua dua) {
        long result = 0;
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(RozEidFitrContract.RozEidFitrEntry.COLUMN_NAME_ARABIC_PART, dua.getDua_arabic_part());
            contentValues.put(RozEidFitrContract.RozEidFitrEntry.COLUMN_NAME_URDU_PART, dua.getDua_urdu_part());
            result = msqLiteDatabase.insert(RozEidFitrContract.RozEidFitrEntry.TABLE_NAME, null, contentValues);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }

    public void bulkInsert(ArrayList<Dua> arrayList) {
        for (Dua item : arrayList) {
            insert(item);
        }


    }

    public long deleteAll() {
        try {
            msqLiteDatabase.execSQL(RozEidFitrContract.SQL_DELETE_ALL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
