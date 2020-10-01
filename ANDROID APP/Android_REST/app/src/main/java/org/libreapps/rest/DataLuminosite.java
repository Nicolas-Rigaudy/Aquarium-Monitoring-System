package org.libreapps.rest;
import android.util.Log;

import org.libreapps.rest.obj.Luminosite;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class DataLuminosite {

    private ArrayList<Luminosite> listLuminosites = new ArrayList<Luminosite>();
    private ConnectionRest connectionRest = null;

    //constructeur
    public DataLuminosite() {
    }

    public String getLuminosite() {
        listLuminosites = refreshLuminosites();
        Log.v("Liste de la luminosite", String.valueOf(listLuminosites));
        Luminosite obj;

        if(listLuminosites != null) {
            obj = listLuminosites.get(listLuminosites.size() - 1);
            String luminosite = "" + obj.getLuminosite();
            return luminosite;
        }
        return null;
    }

    public ArrayList<Luminosite> refreshLuminosites() {
        try {
            String url = "http://e243fd77-76ac-422a-b430-369e1542d528.pub.instances.scw.cloud/luminosite/";
            connectionRest = new ConnectionRest(url);
            connectionRest.execute("GET");
            String listJsonObjs = connectionRest.get();
            if(listJsonObjs != null) {
                return connectionRest.parseluminosite(listJsonObjs);
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
