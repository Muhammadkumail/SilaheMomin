package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class DuaAbuHamza1Contract {
    public DuaAbuHamza1Contract() {
    }

    public static abstract class DuaAbuHamza1Entry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_dua_abuhamza1";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + DuaAbuHamza1Entry.TABLE_NAME + "(" + DuaAbuHamza1Entry._ID
            + " INTEGER PRIMERY KEY," + DuaAbuHamza1Entry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + DuaAbuHamza1Entry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + DuaAbuHamza1Entry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + DuaAbuHamza1Entry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + DuaAbuHamza1Entry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + DuaAbuHamza1Entry.TABLE_NAME;
}
