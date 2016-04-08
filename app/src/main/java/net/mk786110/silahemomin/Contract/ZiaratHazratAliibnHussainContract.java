package net.mk786110.silahemomin.Contract;

import android.provider.BaseColumns;


public class ZiaratHazratAliibnHussainContract {
    public ZiaratHazratAliibnHussainContract() {
    }

    public static abstract class ZiaratHazratAliibnHussainEntry implements BaseColumns {
        public static final String TABLE_NAME = "tbl_ziarat_hazrat_ali_ibn_hussain";
        public static final String COLUMN_NAME_ID_ = "id";
        public static final String COLUMN_NAME_ARABIC_PART = "arabic_part";
        public static final String COLUMN_NAME_URDU_PART = "urdu_part";

    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = " ,";

    public static final String SQL_CREATE = "CREATE TABLE " + ZiaratHazratAliibnHussainEntry.TABLE_NAME + "(" + ZiaratHazratAliibnHussainEntry._ID
            + " INTEGER PRIMERY KEY," + ZiaratHazratAliibnHussainEntry.COLUMN_NAME_ID_
            + TEXT_TYPE + COMMA_SEP + ZiaratHazratAliibnHussainEntry.COLUMN_NAME_ARABIC_PART
            + TEXT_TYPE + COMMA_SEP + ZiaratHazratAliibnHussainEntry.COLUMN_NAME_URDU_PART
            + ")";


    public static final String SQL_SELECT_ALL = "SELECT * FROM " + ZiaratHazratAliibnHussainEntry.TABLE_NAME;
    public static final String SQL_DELETE_ALL = "DELETE FROM " + ZiaratHazratAliibnHussainEntry.TABLE_NAME;
    public static final String SQL_DROP_TABLE = "DROP TABLE IF EXISTS " + ZiaratHazratAliibnHussainEntry.TABLE_NAME;
}
