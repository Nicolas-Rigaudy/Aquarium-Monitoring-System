package org.libreapps.rest;

import android.util.Log;

import org.libreapps.rest.obj.Luminosite;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * TABLE HELPER CLASS. GETS ARRAYLIST FROM SQLITE DATABASE AND RETURNS A MULTIDIMENSIONAL ARRAY FOR BINDING TO OUR ADAPTER
 */
public class LuminositeTableModel {

    //DECLARATIONS
    private String[] columnNames = {"Id","Timestamp","Luminosite"};
    private ArrayList<Luminosite> listLuminosites = new ArrayList<Luminosite>();
    private ConnectionRest connectionRest = null;

    //CONSTRUCTOR
    public LuminositeTableModel() {
    }

    //RETURN TABLE HEADERS
    public String[] getLuminositeHeaders() {
        return columnNames;
    }

    //RETURN TABLE ROWS
    public  String[][] getLuminosites() {
        listLuminosites = refreshLuminosites();
        Log.v("Liste de la luminosite", String.valueOf(listLuminosites));
        Luminosite obj;

        if(listLuminosites != null) {
            String[][] luminosites = new String[listLuminosites.size()][3];

            for (int i = 0; i < listLuminosites.size(); i++) {
                obj = listLuminosites.get(i);
                luminosites[i][0] = "" + obj.getId();
                luminosites[i][1] = obj.getTimestamp();
                luminosites[i][2] = "" + obj.getLuminosite();
            }
            return luminosites;
        }
        return null;
    }

    public ArrayList<Luminosite> refreshLuminosites(){
        try{
            connectionRest = new ConnectionRest();
            connectionRest.execute("GET");
            String listJsonObjs = connectionRest.get();
            if(listJsonObjs != null) {
                return connectionRest.parse(listJsonObjs);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Luminosite get(int row){

        return listLuminosites.get(row);
    }
}
