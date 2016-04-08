package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class ShabanNimeShabanContract {
    public ShabanNimeShabanContract() {
    }

    public static abstract class ShabanNimeShabanEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_shaban_nimeshaban";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + ShabanNimeShabanEntry.TABLE_NAME + "(" + ShabanNimeShabanEntry._ID
            + " INTEGER PRIMERY KEY," + ShabanNimeShabanEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + ShabanNimeShabanEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + ShabanNimeShabanEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + ShabanNimeShabanEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + ShabanNimeShabanEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ShabanNimeShabanEntry.TABLE_NAME;
}
