package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class ShabanThirdShabanContract {
    public ShabanThirdShabanContract() {
    }

    public static abstract class ShabanThirdShabanEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_shaban_thirdshaban";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + ShabanThirdShabanEntry.TABLE_NAME + "(" + ShabanThirdShabanEntry._ID
            + " INTEGER PRIMERY KEY," + ShabanThirdShabanEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + ShabanThirdShabanEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + ShabanThirdShabanEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + ShabanThirdShabanEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + ShabanThirdShabanEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ShabanThirdShabanEntry.TABLE_NAME;
}
