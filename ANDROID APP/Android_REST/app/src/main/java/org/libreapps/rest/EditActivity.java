package org.libreapps.rest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{

    private int id = 0;
    private String name = "";
    private String type = "";
    private double price = 0.0;
    private EditText nameEditText;
    private EditText typeEditText;
    private EditText priceEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        TextView idText = findViewById(R.id.textView_id);

        nameEditText = findViewById(R.id.nameEditTxt);
        String nameEditTextValue = nameEditText.getText().toString();
        typeEditText = findViewById(R.id.typeEditTxt);
        String typeEditTextValue = typeEditText.getText().toString();
        priceEditText = findViewById(R.id.priceEditTxt);
        String priceEditTextValue = priceEditText.getText().toString();

        Button button_ok= findViewById(R.id.button_ok);
        button_ok.setOnClickListener(this);
        Button button_cancel= findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(this);

        id = getIntent().getIntExtra("id",0);
        name = getIntent().getStringExtra("name");
        type = getIntent().getStringExtra("type");
        price = getIntent().getDoubleExtra("price", 0.0);

        if(id!=0){
            idText.setText(""+id);
            nameEditText.setText(name);
            typeEditText.setText(type);
            priceEditText.setText(""+price);
            button_cancel.setText("Supprimer");
            button_ok.setText("Modifier");
        }
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_ok:
                try {
                    ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject product = new JSONObject();
                    if(id!=0) {
                        product.put("id", id);
                    }
                    product.put("name", nameEditText.getText().toString());
                    product.put("type", typeEditText.getText().toString());
                    product.put("price", Double.parseDouble(priceEditText.getText().toString()));
                    connectionRest.setJsonObj(product);
                    if(id!=0) { // Modification
                        connectionRest.execute("PUT");
                    }else{ // Creation
                        connectionRest.execute("POST");
                    }
                    Intent intent = new Intent(EditActivity.this, MainActivity.class);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            case R.id.button_cancel:
                if(id!=0){ // Suppression
                    try {
                        ConnectionRest connectionRest = new ConnectionRest();
                        JSONObject product = new JSONObject();
                        product.put("id", id);
                        connectionRest.setJsonObj(product);
                        connectionRest.execute("DELETE");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
        }
    }
}
