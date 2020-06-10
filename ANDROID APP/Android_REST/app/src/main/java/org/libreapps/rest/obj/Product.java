package org.libreapps.rest.obj;

import org.json.JSONObject;

public class Product  {
    private int id;
    private String name;
    private String type;
    private double price;

    public Product(int pId) {
    	 id =  pId;
         name = "<NAME>";
         type = "<TYPE>";
         price = 1.0;
    }
    
    public Product(JSONObject jObject) {
        id = jObject.optInt("id");
        name = jObject.optString("name");
        type = jObject.optString("type");
        price = jObject.optDouble("price");
    }
    
    public Object elementAt(int pNumColonne){
		switch (pNumColonne) {
		case 0:
			return getId();
		case 1:
			return getName();
		case 2:
			return getType();
		case 3:
			return getPrice();
		default:
			return null;
		}
	}

    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    
    public void setName(String pName) {  name=pName; }
    public void setType(String pType) {  type=pType; }
    public void setPrice(double pPrice) {  price=pPrice; }

}