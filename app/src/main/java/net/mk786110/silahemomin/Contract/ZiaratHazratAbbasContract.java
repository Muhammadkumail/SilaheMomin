package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class ZiaratHazratAbbasContract {
    public ZiaratHazratAbbasContract() {
    }

    public static abstract class ZiaratHazratAbbasEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_ziarat_hazrat_abbas_ibn_ali";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + ZiaratHazratAbbasEntry.TABLE_NAME + "(" + ZiaratHazratAbbasEntry._ID
            + " INTEGER PRIMERY KEY," + ZiaratHazratAbbasEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + ZiaratHazratAbbasEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + ZiaratHazratAbbasEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + ZiaratHazratAbbasEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + ZiaratHazratAbbasEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ZiaratHazratAbbasEntry.TABLE_NAME;
}
