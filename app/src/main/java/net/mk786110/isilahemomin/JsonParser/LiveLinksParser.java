package net.mk786110.isilahemomin.JsonParser;

import net.mk786110.isilahemomin.Http.MyHttpClient;
import net.mk786110.isilahemomin.Model.LiveLinks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class LiveLinksParser {


    public ArrayList<LiveLinks> getParseDua(String url) {

        MyHttpClient myHttpClient = new MyHttpClient();
        ArrayList<LiveLinks> arrayList = new ArrayList<>();

        String strJson = url;
        strJson = myHttpClient.httpGet(strJson);


        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                LiveLinks links = new LiveLinks();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                links.setLink_changelName(jsonObject.getString("channel_name"));
                links.setLink_tupe(jsonObject.getString("type"));
                links.setLink_url(jsonObject.getString("link"));

                arrayList.add(links);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

}
