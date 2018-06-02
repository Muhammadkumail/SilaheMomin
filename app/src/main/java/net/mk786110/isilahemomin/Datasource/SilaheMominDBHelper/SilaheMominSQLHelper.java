package net.mk786110.isilahemomin.Datasource.SilaheMominDBHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import net.mk786110.isilahemomin.Contract.DuaAbuHamza1Contract;
import net.mk786110.isilahemomin.Contract.DuaAbuHamza2Contract;
import net.mk786110.isilahemomin.Contract.DuaAbuHamza3Contract;
import net.mk786110.isilahemomin.Contract.DuaArafahContract;
import net.mk786110.isilahemomin.Contract.DuaIftitahContract;
import net.mk786110.isilahemomin.Contract.DuaImamZmanaContract;
import net.mk786110.isilahemomin.Contract.DuaJoshanKabeerContract;
import net.mk786110.isilahemomin.Contract.DuaKumailContract;
import net.mk786110.isilahemomin.Contract.DuaMujeerContract;
import net.mk786110.isilahemomin.Contract.DuaNudbahContract;
import net.mk786110.isilahemomin.Contract.DuaSamatContract;
import net.mk786110.isilahemomin.Contract.DuaTawassulContract;
import net.mk786110.isilahemomin.Contract.MuharramNineDinContract;
import net.mk786110.isilahemomin.Contract.MuharramPhelaDinContract;
import net.mk786110.isilahemomin.Contract.MuharramPheliRatContract;
import net.mk786110.isilahemomin.Contract.MuharramRozeAshurContract;
import net.mk786110.isilahemomin.Contract.MuharramShabeAshurContract;
import net.mk786110.isilahemomin.Contract.MuharramTisraDinContract;
import net.mk786110.isilahemomin.Contract.QuraniDuaContract;
import net.mk786110.isilahemomin.Contract.RajabFirstNightContract;
import net.mk786110.isilahemomin.Contract.RajabMushtarekaAmalContract;
import net.mk786110.isilahemomin.Contract.RajabShabe27Contract;
import net.mk786110.isilahemomin.Contract.RajabTeraToPandraContract;
import net.mk786110.isilahemomin.Contract.RajabUmmeDawoodContract;
import net.mk786110.isilahemomin.Contract.RajabZiaratRajabeaContract;
import net.mk786110.isilahemomin.Contract.RamzanMunajatContract;
import net.mk786110.isilahemomin.Contract.RamzanMushtarekaAmalContract;
import net.mk786110.isilahemomin.Contract.RamzanShabe19Contract;
import net.mk786110.isilahemomin.Contract.RamzanShabe21Contract;
import net.mk786110.isilahemomin.Contract.RamzanShabe23Contract;
import net.mk786110.isilahemomin.Contract.RozEidFitrContract;
import net.mk786110.isilahemomin.Contract.RozJummahContract;
import net.mk786110.isilahemomin.Contract.SafarAttaesContract;
import net.mk786110.isilahemomin.Contract.SafarChehlumContract;
import net.mk786110.isilahemomin.Contract.ShabanMushtarekaAmalContract;
import net.mk786110.isilahemomin.Contract.ShabanNimeShabanContract;
import net.mk786110.isilahemomin.Contract.ShabanThirdShabanContract;
import net.mk786110.isilahemomin.Contract.ShabeEidFitrContract;
import net.mk786110.isilahemomin.Contract.ShabeJummahContract;
import net.mk786110.isilahemomin.Contract.SurahAnkabutContract;
import net.mk786110.isilahemomin.Contract.SurahDukhanContract;
import net.mk786110.isilahemomin.Contract.SurahRehmanContract;
import net.mk786110.isilahemomin.Contract.SurahRoomContract;
import net.mk786110.isilahemomin.Contract.SurahYaseenContract;
import net.mk786110.isilahemomin.Contract.ZiaratAshuraContract;
import net.mk786110.isilahemomin.Contract.ZiaratHazratAbbasContract;
import net.mk786110.isilahemomin.Contract.ZiaratHazratAliibnHussainContract;
import net.mk786110.isilahemomin.Contract.ZiaratImamHussainContract;
import net.mk786110.isilahemomin.Contract.ZiaratSayerShohadaContract;
import net.mk786110.isilahemomin.Contract.ZiaratWarisContract;


public class SilaheMominSQLHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "silahemomin.db";
    public static final int DATABASE_VERSION = 3;

    public SilaheMominSQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(MuharramNineDinContract.SQL_CREATE);
        db.execSQL(MuharramPhelaDinContract.SQL_CREATE);
        db.execSQL(MuharramShabeAshurContract.SQL_CREATE);
        db.execSQL(MuharramRozeAshurContract.SQL_CREATE);
        db.execSQL(MuharramPheliRatContract.SQL_CREATE);
        db.execSQL(MuharramTisraDinContract.SQL_CREATE);

        db.execSQL(SafarAttaesContract.SQL_CREATE);
        db.execSQL(SafarChehlumContract.SQL_CREATE);


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

            case  2:
                db.execSQL(MuharramNineDinContract.SQL_CREATE);
                db.execSQL(MuharramPhelaDinContract.SQL_CREATE);
                db.execSQL(MuharramShabeAshurContract.SQL_CREATE);
                db.execSQL(MuharramRozeAshurContract.SQL_CREATE);
                db.execSQL(MuharramPheliRatContract.SQL_CREATE);
                db.execSQL(MuharramTisraDinContract.SQL_CREATE);
                db.execSQL(SafarAttaesContract.SQL_CREATE);
                db.execSQL(SafarChehlumContract.SQL_CREATE);





                // we want both updates, so no break statement here...


       }
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
