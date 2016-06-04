package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class ShabeJummahContract {
    public ShabeJummahContract() {
    }

    public static abstract class ShabeJummahEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_shabe_jummah";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + ShabeJummahEntry.TABLE_NAME + "(" + ShabeJummahEntry._ID
            + " INTEGER PRIMERY KEY," + ShabeJummahEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + ShabeJummahEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + ShabeJummahEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + ShabeJummahEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + ShabeJummahEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ShabeJummahEntry.TABLE_NAME;
}
