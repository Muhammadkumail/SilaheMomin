package net.mk786110.silahemomin.JsonParser;

import net.mk786110.silahemomin.Http.MyHttpClient;
import net.mk786110.silahemomin.Model.Album;
import net.mk786110.silahemomin.Model.Majlis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MolanaParserParser {


    public ArrayList<Album> getParseDua(String url) {

        MyHttpClient myHttpClient = new MyHttpClient();
        ArrayList<Album> arrayList = new ArrayList<>();

        String strJson = url;
        strJson = myHttpClient.httpGet(strJson);


        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                Album links = new Album();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                links.setName(jsonObject.getString("molana_name"));
                links.setMolana_image(jsonObject.getString("molana_pic"));

                arrayList.add(links);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

}
