package net.mk786110.silahemomin.JsonParser;

import net.mk786110.silahemomin.Http.MyHttpClient;
import net.mk786110.silahemomin.Model.Dua;
import net.mk786110.silahemomin.Model.Hadith;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class HadithParser {


    public ArrayList<Hadith> getParseHadith(String url) {

        MyHttpClient myHttpClient = new MyHttpClient();
        ArrayList<Hadith> arrayList = new ArrayList<>();

        String strJson = url;
        strJson = myHttpClient.httpGet(strJson);


        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                Hadith hadith = new Hadith();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                hadith.setHadith(jsonObject.getString("hadith"));
                hadith.setHadith_author(jsonObject.getString("imam_name"));

                arrayList.add(hadith);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

}
