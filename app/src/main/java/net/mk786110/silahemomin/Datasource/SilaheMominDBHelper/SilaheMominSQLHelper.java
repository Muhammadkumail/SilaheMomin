package net.mk786110.silahemomin.Datasource.SilaheMominDBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.mk786110.silahemomin.Contract.DuaAbuHamza1Contract;
import net.mk786110.silahemomin.Contract.DuaAbuHamza2Contract;
import net.mk786110.silahemomin.Contract.DuaAbuHamza3Contract;
import net.mk786110.silahemomin.Contract.DuaArafahContract;
import net.mk786110.silahemomin.Contract.DuaIftitahContract;
import net.mk786110.silahemomin.Contract.DuaImamZmanaContract;
import net.mk786110.silahemomin.Contract.DuaJoshanKabeerContract;
import net.mk786110.silahemomin.Contract.DuaKumailContract;
import net.mk786110.silahemomin.Contract.DuaMujeerContract;
import net.mk786110.silahemomin.Contract.DuaNudbahContract;
import net.mk786110.silahemomin.Contract.DuaSamatContract;
import net.mk786110.silahemomin.Contract.DuaTawassulContract;
import net.mk786110.silahemomin.Contract.QuraniDuaContract;
import net.mk786110.silahemomin.Contract.RajabFirstNightContract;
import net.mk786110.silahemomin.Contract.RajabMushtarekaAmalContract;
import net.mk786110.silahemomin.Contract.RajabShabe27Contract;
import net.mk786110.silahemomin.Contract.RajabTeraToPandraContract;
import net.mk786110.silahemomin.Contract.RajabUmmeDawoodContract;
import net.mk786110.silahemomin.Contract.RajabZiaratRajabeaContract;
import net.mk786110.silahemomin.Contract.RamzanMunajatContract;
import net.mk786110.silahemomin.Contract.RamzanMushtarekaAmalContract;
import net.mk786110.silahemomin.Contract.RamzanShabe19Contract;
import net.mk786110.silahemomin.Contract.RamzanShabe21Contract;
import net.mk786110.silahemomin.Contract.RamzanShabe23Contract;
import net.mk786110.silahemomin.Contract.RozEidFitrContract;
import net.mk786110.silahemomin.Contract.RozJummahContract;
import net.mk786110.silahemomin.Contract.ShabanMushtarekaAmalContract;
import net.mk786110.silahemomin.Contract.ShabanNimeShabanContract;
import net.mk786110.silahemomin.Contract.ShabanThirdShabanContract;
import net.mk786110.silahemomin.Contract.ShabeEidFitrContract;
import net.mk786110.silahemomin.Contract.ShabeJummahContract;
import net.mk786110.silahemomin.Contract.SurahAnkabutContract;
import net.mk786110.silahemomin.Contract.SurahDukhanContract;
import net.mk786110.silahemomin.Contract.SurahRehmanContract;
import net.mk786110.silahemomin.Contract.SurahRoomContract;
import net.mk786110.silahemomin.Contract.SurahYaseenContract;
import net.mk786110.silahemomin.Contract.ZiaratAshuraContract;
import net.mk786110.silahemomin.Contract.ZiaratHazratAbbasContract;
import net.mk786110.silahemomin.Contract.ZiaratHazratAliibnHussainContract;
import net.mk786110.silahemomin.Contract.ZiaratImamHussainContract;
import net.mk786110.silahemomin.Contract.ZiaratSayerShohadaContract;
import net.mk786110.silahemomin.Contract.ZiaratWarisContract;


public class SilaheMominSQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "silahemomin.db";
    public static final int DATABASE_VERSION = 2;

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
        db.execSQL(DuaSamatContract.SQL_CREATE);
        db.execSQL(DuaMujeerContract.SQL_CREATE);
        db.execSQL(QuraniDuaContract.SQL_CREATE);
        db.execSQL(DuaNudbahContract.SQL_CREATE);
        db.execSQL(DuaArafahContract.SQL_CREATE);


        db.execSQL(SurahAnkabutContract.SQL_CREATE);
        db.execSQL(SurahDukhanContract.SQL_CREATE);
        db.execSQL(SurahRoomContract.SQL_CREATE);
        db.execSQL(SurahRehmanContract.SQL_CREATE);
        db.execSQL(SurahYaseenContract.SQL_CREATE);


        db.execSQL(ZiaratAshuraContract.SQL_CREATE);
        db.execSQL(ZiaratWarisContract.SQL_CREATE);
        db.execSQL(ZiaratHazratAbbasContract.SQL_CREATE);
        db.execSQL(ZiaratImamHussainContract.SQL_CREATE);
        db.execSQL(ZiaratSayerShohadaContract.SQL_CREATE);
        db.execSQL(ZiaratHazratAliibnHussainContract.SQL_CREATE);

        db.execSQL(RajabFirstNightContract.SQL_CREATE);
        db.execSQL(RajabMushtarekaAmalContract.SQL_CREATE);
        db.execSQL(RajabUmmeDawoodContract.SQL_CREATE);
        db.execSQL(RajabZiaratRajabeaContract.SQL_CREATE);
        db.execSQL(RajabTeraToPandraContract.SQL_CREATE);
        db.execSQL(RajabShabe27Contract.SQL_CREATE);

        db.execSQL(RamzanMunajatContract.SQL_CREATE);
        db.execSQL(RamzanMushtarekaAmalContract.SQL_CREATE);
        db.execSQL(RamzanShabe19Contract.SQL_CREATE);
        db.execSQL(RamzanShabe21Contract.SQL_CREATE);
        db.execSQL(RamzanShabe23Contract.SQL_CREATE);

        db.execSQL(ShabanMushtarekaAmalContract.SQL_CREATE);
        db.execSQL(ShabanNimeShabanContract.SQL_CREATE);
        db.execSQL(ShabanThirdShabanContract.SQL_CREATE);

        db.execSQL(ShabeJummahContract.SQL_CREATE);
        db.execSQL(ShabeEidFitrContract.SQL_CREATE);
        db.execSQL(RozEidFitrContract.SQL_CREATE);
        db.execSQL(RozJummahContract.SQL_CREATE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch(oldVersion) {
            case 1:
                db.execSQL(DuaNudbahContract.SQL_CREATE);
                db.execSQL(ShabeJummahContract.SQL_CREATE);
                db.execSQL(RozJummahContract.SQL_CREATE);
                db.execSQL(ShabeEidFitrContract.SQL_CREATE);
                db.execSQL(RozEidFitrContract.SQL_CREATE);
                db.execSQL(SurahRehmanContract.SQL_CREATE);
                db.execSQL(DuaArafahContract.SQL_CREATE);
                db.execSQL(SurahYaseenContract.SQL_CREATE);




                // we want both updates, so no break statement here...


       }
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
