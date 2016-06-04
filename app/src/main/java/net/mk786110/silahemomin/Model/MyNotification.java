package net.mk786110.silahemomin.Model;

import java.io.Serializable;

public class MyNotification implements Serializable {

    private String title;
    private String msg;
    private String activity_english_part;
    private String activity_urdu_part;
    private String activity_pakage_name;
    private String image_url;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }



    public String getActivity_english_part() {
        return activity_english_part;
    }

    public void setActivity_english_part(String activity_english_part) {
        this.activity_english_part = activity_english_part;
    }

    public String getActivity_urdu_part() {
        return activity_urdu_part;
    }

    public void setActivity_urdu_part(String activity_urdu_part) {
        this.activity_urdu_part = activity_urdu_part;
    }

    public String getActivity_pakage_name() {
        return activity_pakage_name;
    }

    public void setActivity_pakage_name(String activity_pakage_name) {
        this.activity_pakage_name = activity_pakage_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
