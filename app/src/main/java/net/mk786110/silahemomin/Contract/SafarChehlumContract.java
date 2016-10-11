package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class SafarChehlumContract {
    public SafarChehlumContract() {
    }

    public static abstract class SafarChelumEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_chehlum";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + SafarChelumEntry.TABLE_NAME + "(" + SafarChelumEntry._ID
            + " INTEGER PRIMERY KEY," + SafarChelumEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + SafarChelumEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + SafarChelumEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + SafarChelumEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + SafarChelumEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + SafarChelumEntry.TABLE_NAME;
}
