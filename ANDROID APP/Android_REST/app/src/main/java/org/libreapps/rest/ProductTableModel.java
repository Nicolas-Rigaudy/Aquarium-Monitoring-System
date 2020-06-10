package org.libreapps.rest;

import android.util.Log;

import org.libreapps.rest.obj.Product;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * TABLE HELPER CLASS. GETS ARRAYLIST FROM SQLITE DATABASE AND RETURNS A MULTIDIMENSIONAL ARRAY FOR BINDING TO OUR ADAPTER
 */
public class ProductTableModel {

    //DECLARATIONS
    private String[] columnNames = {"Id","Name","Type","Price"};
    private ArrayList<Product> listProducts = new ArrayList<Product>();
    private ConnectionRest connectionRest = null;

    //CONSTRUCTOR
    public ProductTableModel() {
    }

    //RETURN TABLE HEADERS
    public String[] getProductHeaders() {
        return columnNames;
    }

    //RETURN TABLE ROWS
    public  String[][] getProducts() {
        listProducts = refreshProducts();
        Log.v("Liste des produits", String.valueOf(listProducts));
        Product obj;

        if(listProducts != null) {
            String[][] products = new String[listProducts.size()][4];

            for (int i = 0; i < listProducts.size(); i++) {
                obj = listProducts.get(i);
                products[i][0] = "" + obj.getId();
                products[i][1] = obj.getName();
                products[i][2] = obj.getType();
                products[i][3] = "" + obj.getPrice();
            }
            return products;
        }
        return null;
    }

    public ArrayList<Product> refreshProducts(){
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

   public Product get(int row){
        return listProducts.get(row);
    }
}





