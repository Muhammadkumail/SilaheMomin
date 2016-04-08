package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class RajabZiaratRajabeaContract {
    public RajabZiaratRajabeaContract() {
    }

    public static abstract class RajabZiaratRajabeaEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_rajab_ziaratrajabea";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + RajabZiaratRajabeaEntry.TABLE_NAME + "(" + RajabZiaratRajabeaEntry._ID
            + " INTEGER PRIMERY KEY," + RajabZiaratRajabeaEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + RajabZiaratRajabeaEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + RajabZiaratRajabeaEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + RajabZiaratRajabeaEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + RajabZiaratRajabeaEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + RajabZiaratRajabeaEntry.TABLE_NAME;
}
