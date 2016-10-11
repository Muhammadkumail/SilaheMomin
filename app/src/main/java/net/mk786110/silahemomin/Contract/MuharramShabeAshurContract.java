package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class MuharramShabeAshurContract {
    public MuharramShabeAshurContract() {
    }

    public static abstract class MuhrramShabeaSHUREntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_muharram_shabe_ashur";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + MuhrramShabeaSHUREntry.TABLE_NAME + "(" + MuhrramShabeaSHUREntry._ID
            + " INTEGER PRIMERY KEY," + MuhrramShabeaSHUREntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + MuhrramShabeaSHUREntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + MuhrramShabeaSHUREntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + MuhrramShabeaSHUREntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + MuhrramShabeaSHUREntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + MuhrramShabeaSHUREntry.TABLE_NAME;
}
