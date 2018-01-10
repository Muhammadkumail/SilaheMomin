package net.mk786110.silahemomin.Model;

public class Majlis {
   // private String dua_name;
    private String molana_name;
    private String majlis_topic;
    private String majlis_link;
    private String majlis_link_type;


    public String getMajlis_link() {
        return majlis_link;
    }

    public String getMajlis_topic() {
        return majlis_topic;
    }

    public String getMolana_name() {
        return molana_name;
    }

    public void setMajlis_link(String majlis_link) {
        this.majlis_link = majlis_link;
    }

    public void setMajlis_topic(String majlis_topic) {
        this.majlis_topic = majlis_topic;
    }

    public void setMolana_name(String molana_name) {
        this.molana_name = molana_name;
    }

    public String getMajlis_link_type() {
        return majlis_link_type;
    }

    public void setMajlis_link_type(String majlis_link_type) {
        this.majlis_link_type = majlis_link_type;
    }
}
