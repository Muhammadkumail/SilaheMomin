package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class RamzanShabe23Contract {
    public RamzanShabe23Contract() {
    }

    public static abstract class RamzanShabe23Entry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_ramzan_teyyeskamal";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + RamzanShabe23Entry.TABLE_NAME + "(" + RamzanShabe23Entry._ID
            + " INTEGER PRIMERY KEY," + RamzanShabe23Entry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + RamzanShabe23Entry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + RamzanShabe23Entry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + RamzanShabe23Entry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + RamzanShabe23Entry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + RamzanShabe23Entry.TABLE_NAME;
}
