package org.libreapps.rest.obj;

import org.json.JSONObject;

public class Temperature  {
    private int id;
    private String timestamp;
    private int temperature;

    public Temperature(int pId) {
        id =  pId;
        timestamp = "<TIMESTAMP>";
        temperature = 0;
    }

    public Temperature(JSONObject jObject) {
        id = jObject.optInt("id");
        timestamp = jObject.optString("timestamp");
        temperature = jObject.optInt("temperature");
    }

    public Object elementAt(int pNumColonne){
        switch (pNumColonne) {
            case 0:
                return getId();
            case 1:
                return getTimestamp();
            case 2:
                return getTemperature();
            default:
                return null;
        }
    }

    public int getId() { return id; }
    public String getTimestamp() { return timestamp; }
    public int getTemperature() { return temperature; }

    public void setTimestamp(String pTimestamp) {  timestamp=pTimestamp; }
    public void setTemperature(int pTemperature) {  temperature=pTemperature; }

}