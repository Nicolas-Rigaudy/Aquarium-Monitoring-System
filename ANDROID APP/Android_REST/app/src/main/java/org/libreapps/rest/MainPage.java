package org.libreapps.rest;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.libreapps.rest.obj.Luminosite;
import org.libreapps.rest.obj.Temperature;


import android.os.Bundle;
import android.provider.ContactsContract;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    DataTemperature datatemp;
    DataLuminosite datalumi;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        datatemp = new DataTemperature();
        datalumi = new DataLuminosite();
        String tempstr= "" + datatemp.getTemperature();
        String lumistr= "" + datalumi.getLuminosite();

        Log.v("valeur", lumistr);
        Log.v("valeur", tempstr);

        ArrayList<DataCard> dataCards = new ArrayList<>();
        dataCards.add(new DataCard("Brightness",lumistr + "%"));
        dataCards.add(new DataCard("Temperature",tempstr + "°C"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerAdapter(dataCards);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}
