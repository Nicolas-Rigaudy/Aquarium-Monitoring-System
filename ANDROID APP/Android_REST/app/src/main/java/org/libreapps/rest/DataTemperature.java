package org.libreapps.rest;
import android.util.Log;

import org.libreapps.rest.obj.Temperature;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DataTemperature {

    private ArrayList<Temperature> listTemperatures = new ArrayList<Temperature>();
    private ConnectionRest connectionRest = null;

    //constructeur
    public DataTemperature() {
    }

    public String getTemperature() {
        listTemperatures = refreshTemperatures();
        Log.v("Liste de temperature", String.valueOf(listTemperatures));
        Temperature obj;

        if(listTemperatures != null) {
            obj = listTemperatures.get(listTemperatures.size() - 1);
            String temperature = "" + obj.getTemperature();
            return temperature;
        }
        return null;
    }

    public ArrayList<Temperature> refreshTemperatures() {
        try {
            String url = "http://e243fd77-76ac-422a-b430-369e1542d528.pub.instances.scw.cloud/temperature/";
            connectionRest = new ConnectionRest(url);
            connectionRest.execute("GET");
            String listJsonObjs = connectionRest.get();
            if(listJsonObjs != null) {
                return connectionRest.parsetemperature(listJsonObjs);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Temperature get(int row){

        return listTemperatures.get(row);
    }
}