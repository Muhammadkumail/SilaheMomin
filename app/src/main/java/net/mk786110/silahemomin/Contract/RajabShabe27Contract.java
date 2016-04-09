package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class RajabShabe27Contract {
    public RajabShabe27Contract() {
    }

    public static abstract class RajabShabe27Entry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_rajab_shabesattayes";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + RajabShabe27Entry.TABLE_NAME + "(" + RajabShabe27Entry._ID
            + " INTEGER PRIMERY KEY," + RajabShabe27Entry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + RajabShabe27Entry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + RajabShabe27Entry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + RajabShabe27Entry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + RajabShabe27Entry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + RajabShabe27Entry.TABLE_NAME;
}
