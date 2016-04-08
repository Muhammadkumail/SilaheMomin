package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class DuaImamZmanaContract {
    public DuaImamZmanaContract() {
    }

    public static abstract class DuaImamZmanaEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_dua_imamzamana";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + DuaImamZmanaEntry.TABLE_NAME + "(" + DuaImamZmanaEntry._ID
            + " INTEGER PRIMERY KEY," + DuaImamZmanaEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + DuaImamZmanaEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + DuaImamZmanaEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + DuaImamZmanaEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + DuaImamZmanaEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + DuaImamZmanaEntry.TABLE_NAME;
}
