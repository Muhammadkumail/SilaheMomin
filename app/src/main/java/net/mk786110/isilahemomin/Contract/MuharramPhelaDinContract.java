package net.mk786110.isilahemomin.Contract;

import android.provider.BaseColumns;


public class MuharramPhelaDinContract {
    public MuharramPhelaDinContract() {
    }

    public static abstract class MuharramPhelaDinEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_muharram_phela_din";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + MuharramPhelaDinEntry.TABLE_NAME + "(" + MuharramPhelaDinEntry._ID
            + " INTEGER PRIMERY KEY," + MuharramPhelaDinEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + MuharramPhelaDinEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + MuharramPhelaDinEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + MuharramPhelaDinEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + MuharramPhelaDinEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + MuharramPhelaDinEntry.TABLE_NAME;
}
