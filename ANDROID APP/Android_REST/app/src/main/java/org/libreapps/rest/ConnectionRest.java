package org.libreapps.rest;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.rest.obj.Product;
import org.libreapps.rest.obj.Luminosite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ConnectionRest extends AsyncTask<String, Void, String> {
    //private final static String URL = "http://api.munier.me/gr12/product/";
    private final static String URL = "http://e243fd77-76ac-422a-b430-369e1542d528.pub.cloud.scaleway.com/product/";
    private JSONObject jsonObj = null;

    @Override
    protected String doInBackground(String... strings) {
        try {
        		// GET / POST (ADD) / PUT (UPD) / DELETE
           //jsonObj = new JSONObject();
           /* json.put("typeObj","product");
            json.put("id",1);
            json.put("name","Pomme de terre");
            json.put("type","Legume");
            json.put("price",3.2);*/

            //Log.v("RETOUR ", get("DELETE"));

            //Log.v("RETOUR ", get("PUT");

           // Log.v("RETOUR ", get("POST"));

            //List<Product> listProduct = parse(get("GET"));
            //for (int i=0;i<listProduct.size();i++){
            //    Log.v("PRODUIT ", listProduct.get(i).getName()+" "+listProduct.get(i).getType()+" "+listProduct.get(i).getPrice()+"\n");
            //}
            return get(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String methode) throws IOException, JSONException {
        String url = URL;
        InputStream is = null;
        String parameters = "";
        Log.v("methode", methode);
        if(!methode.equals("POST")&&(jsonObj!=null)){
            url += jsonObj.getInt("id");
        }
        if(jsonObj != null){
            if(methode.equals("PUT")){
                jsonObj.remove("id");

            }
            parameters  = "data="+URLEncoder.encode(jsonObj.toString(), "utf-8");
            Log.v("URL", url+" "+parameters);
        }
        try {
            final HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod(methode);

            // Pour les methode POST et PUT on envoie les parametre avec l'OutputStreamWriter
            if(methode.equals("POST")||methode.equals("PUT")){
                conn.setDoInput(true);
                conn.setDoOutput(true);
                OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
                out.write(parameters);// here i sent the parameter
                out.close();
            }else{
                conn.setDoInput(true);
                conn.connect();
            }

            is = conn.getInputStream();
            // Lit le InputStream et l'enregistre dans une string
            return readIt(is);
        } finally {
            // Pour etre sur que le InputStream soit ferme apres avoir quitter l'application
            if (is != null) {
                is.close();
            }
        }
    }

    private String readIt(InputStream is) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            response.append(line).append('\n');
        }
        return response.toString();
    }

    public ArrayList<Luminosite> parse(final String json) {
        try {
            final ArrayList<Luminosite> luminosites = new ArrayList<>();
            final JSONArray jLuminositeArray = new JSONArray(json);
            for (int i = 0; i < jLuminositeArray.length(); i++) {
                luminosites.add(new Luminosite(jLuminositeArray.optJSONObject(i)));
            }
            return luminosites;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }

    public void setJsonObj(JSONObject jsonObj){
        this.jsonObj = jsonObj;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
