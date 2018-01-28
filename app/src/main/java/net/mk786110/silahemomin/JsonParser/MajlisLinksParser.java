package net.mk786110.silahemomin.JsonParser;

import net.mk786110.silahemomin.Constant.C;
import net.mk786110.silahemomin.Http.MyHttpClient;
import net.mk786110.silahemomin.Model.LiveLinks;
import net.mk786110.silahemomin.Model.Majlis;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MajlisLinksParser {


    public ArrayList<Majlis> getParseMajlis(String url) {

        MyHttpClient myHttpClient = new MyHttpClient();
        ArrayList<Majlis> arrayList = new ArrayList<>();

        String strJson = url;
        strJson = myHttpClient.httpGet(strJson);
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            for (int i = 0; i < jsonArray.length(); i++) {
                Majlis links = new Majlis();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                links.setMajlis_link(jsonObject.getString("full_link"));
                links.setMajlis_topic(jsonObject.getString("topic_name"));
                links.setMajlis_link_type(jsonObject.getString("video_type"));

                arrayList.add(links);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

}
