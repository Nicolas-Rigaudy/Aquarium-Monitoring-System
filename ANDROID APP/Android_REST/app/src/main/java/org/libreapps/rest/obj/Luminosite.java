package org.libreapps.rest.obj;

import org.json.JSONObject;

public class Luminosite  {
    private int id;
    private String timestamp;
    private int luminosite;

    public Luminosite(int pId) {
        id =  pId;
        timestamp = "<TIMESTAMP>";
        luminosite = 0;
    }

    public Luminosite(JSONObject jObject) {
        id = jObject.optInt("id");
        timestamp = jObject.optString("timestamp");
        luminosite = jObject.optInt("luminosite");
    }

    public Object elementAt(int pNumColonne){
        switch (pNumColonne) {
            case 0:
                return getId();
            case 1:
                return getTimestamp();
            case 2:
                return getLuminosite();
            default:
                return null;
        }
    }

    public int getId() { return id; }
    public String getTimestamp() { return timestamp; }
    public int getLuminosite() { return luminosite; }

    public void setTimestamp(String pTimestamp) {  timestamp=pTimestamp; }
    public void setLuminosite(int pLuminosite) {  luminosite=pLuminosite; }

}