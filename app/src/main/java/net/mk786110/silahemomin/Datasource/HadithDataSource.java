package net.mk786110.silahemomin.Datasource;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.JsonParser.DuaParser;
import net.mk786110.silahemomin.JsonParser.HadithParser;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.Model.Hadith;

import java.util.ArrayList;


public class HadithDataSource {
    public ArrayList<Hadith> getList() {

        HadithParser hadithParser=new HadithParser();
        return hadithParser.getParseHadith(C.RandomHadith);

    }
}
