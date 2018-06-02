package net.mk786110.isilahemomin.Contract;

import android.provider.BaseColumns;


public class SafarAttaesContract {
    public SafarAttaesContract() {
    }

    public static abstract class SafarAttaesEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_safar_attaes";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + SafarAttaesEntry.TABLE_NAME + "(" + SafarAttaesEntry._ID
            + " INTEGER PRIMERY KEY," + SafarAttaesEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + SafarAttaesEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + SafarAttaesEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + SafarAttaesEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + SafarAttaesEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + SafarAttaesEntry.TABLE_NAME;
}
