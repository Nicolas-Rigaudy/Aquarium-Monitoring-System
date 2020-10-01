package org.libreapps.rest;

import android.util.Log;

import org.libreapps.rest.obj.Temperature;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * TABLE HELPER CLASS. GETS ARRAYLIST FROM SQLITE DATABASE AND RETURNS A MULTIDIMENSIONAL ARRAY FOR BINDING TO OUR ADAPTER
 */
public class TemperatureTableModel {

    //DECLARATIONS
    private String[] columnNames = {"Id","Timestamp","Temperature"};
    private ArrayList<Temperature> listTemperatures = new ArrayList<Temperature>();
    private ConnectionRest connectionRest = null;

    //CONSTRUCTOR
    public TemperatureTableModel() {
    }

    //RETURN TABLE HEADERS
    public String[] getTemperatureHeaders() {
        return columnNames;
    }

    //RETURN TABLE ROWS
    public  String[][] getTemperatures() {
        listTemperatures = refreshTemperatures();
        Log.v("Liste de la Temperature", String.valueOf(listTemperatures));
        Temperature obj;

        if(listTemperatures != null) {
            String[][] temperatures = new String[listTemperatures.size()][3];

            for (int i = 0; i < listTemperatures.size(); i++) {
                obj = listTemperatures.get(i);
                temperatures[i][0] = "" + obj.getId();
                temperatures[i][1] = obj.getTimestamp();
                temperatures[i][2] = "" + obj.getTemperature();
            }
            return temperatures;
        }
        return null;
    }

    public ArrayList<Temperature> refreshTemperatures(){
        try{
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
