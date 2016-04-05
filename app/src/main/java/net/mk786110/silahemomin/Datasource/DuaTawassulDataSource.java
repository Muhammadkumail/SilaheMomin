package net.mk786110.silahemomin.Datasource;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.JsonParser.DuaParser;
import net.mk786110.silahemomin.Model.Dua;

import java.util.ArrayList;


public class DuaTawassulDataSource {
    public ArrayList<Dua> getList() {

        DuaParser duaParser=new DuaParser();
        return duaParser.getParseDua(C.DuaTawassulJson);


        /*ArrayList<Dua> dualist = new ArrayList<Dua>();

        Dua item = new Dua();
        for (int i = 0; i < 10; i++) {
            item.setDua_arabic_part("اَللّٰھُمَّ إِنِّی أَسْأَلُکَ بِرَحْمَتِکَ الَّتِی وَسِعَتْ کُلَّ شَیْءٍ وَبِقُوَّتِکَ الَّتِی قَھَرْتَ بِہا کُلَّ شَیْءٍ");
            item.setDua_urdu_part("اے معبود میں تجھ سے سوال کرتا ہوں تیری رحمت کے ذریعے جوہر شی پر محیط ہے تیری قوت کے ذریعے جس سے تو نے ہر شی کو زیر نگیں کیا ");
            dualist.add(item);

        }
        return dualist;*/
    }
}
