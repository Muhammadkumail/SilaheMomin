package net.mk786110.isilahemomin.Datasource;

import net.mk786110.isilahemomin.Constant.C;
import net.mk786110.isilahemomin.JsonParser.HadithParser;
import net.mk786110.isilahemomin.Model.Hadith;

import java.util.ArrayList;


public class HadithDataSource {
    public ArrayList<Hadith> getList() {

        HadithParser hadithParser=new HadithParser();
        return hadithParser.getParseHadith(C.RandomHadith);

    }
}
