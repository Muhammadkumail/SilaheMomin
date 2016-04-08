package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class SurahAnkabutContract {
    public SurahAnkabutContract() {
    }

    public static abstract class SurahAnkabutEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_surah_ankabut";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + SurahAnkabutEntry.TABLE_NAME + "(" + SurahAnkabutEntry._ID
            + " INTEGER PRIMERY KEY," + SurahAnkabutEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + SurahAnkabutEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + SurahAnkabutEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + SurahAnkabutEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + SurahAnkabutEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + SurahAnkabutEntry.TABLE_NAME;
}
