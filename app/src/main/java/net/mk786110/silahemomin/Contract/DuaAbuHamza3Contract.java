package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class DuaAbuHamza3Contract {
    public DuaAbuHamza3Contract() {
    }

    public static abstract class DuaAbuHamza3Entry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_dua_abuhamza3";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + DuaAbuHamza3Entry.TABLE_NAME + "(" + DuaAbuHamza3Entry._ID
            + " INTEGER PRIMERY KEY," + DuaAbuHamza3Entry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + DuaAbuHamza3Entry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + DuaAbuHamza3Entry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + DuaAbuHamza3Entry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + DuaAbuHamza3Entry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + DuaAbuHamza3Entry.TABLE_NAME;
}
