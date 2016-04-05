package net.mk786110.silahemomin.Datasource;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.JsonParser.DuaParser;
import net.mk786110.silahemomin.Model.Dua;

import java.util.ArrayList;


public class RamzanShabe21DataSource {
    public ArrayList<Dua> getList() {

        DuaParser duaParser = new DuaParser();
        return duaParser.getParseDua(C.RamzanShabe21kaAmal);
    }
}
