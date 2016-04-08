package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class ZiaratWarisContract {
    public ZiaratWarisContract() {
    }

    public static abstract class ZiaratWarisEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_ziarat_waris";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + ZiaratWarisEntry.TABLE_NAME + "(" + ZiaratWarisEntry._ID
            + " INTEGER PRIMERY KEY," + ZiaratWarisEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + ZiaratWarisEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + ZiaratWarisEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + ZiaratWarisEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + ZiaratWarisEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ZiaratWarisEntry.TABLE_NAME;
}
