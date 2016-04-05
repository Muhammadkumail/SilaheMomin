package net.mk786110.silahemomin.JsonParser;

import net.mk786110.silahemomin.Http.MyHttpClient;
import net.mk786110.silahemomin.Model.Dua;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class DuaParser {


    public ArrayList<Dua> getParseDua(String url) {

        MyHttpClient myHttpClient = new MyHttpClient();
        ArrayList<Dua> arrayList = new ArrayList<>();

        String strJson = url;
        strJson = myHttpClient.httpGet(strJson);


        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                Dua dua = new Dua();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                dua.setDua_arabic_part(jsonObject.getString("arabic_part"));
                dua.setDua_urdu_part(jsonObject.getString("urdu_part"));

                arrayList.add(dua);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

}
