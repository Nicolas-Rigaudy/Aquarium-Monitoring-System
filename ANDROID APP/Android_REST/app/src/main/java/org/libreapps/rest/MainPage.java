package org.libreapps.rest;
import android.content.Intent;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.libreapps.rest.obj.Luminosite;
import org.libreapps.rest.obj.Temperature;


import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainPage extends AppCompatActivity {
    DataTemperature datatemp;
    DataLuminosite datalumi;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Intent starterIntent;
    private ArrayList<Integer> fishList;
    private ArrayList<String > speciesList;
    private int nextFish;
    private String nextSpecies;
    private int i;
    private de.hdodenhof.circleimageview.CircleImageView fishImage;
    private TextView speciesName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        starterIntent = getIntent();

        datatemp = new DataTemperature();
        datalumi = new DataLuminosite();
        String tempstr= "" + datatemp.getTemperature();
        String lumistr= "" + datalumi.getLuminosite();

        Log.v("valeur", lumistr);
        Log.v("valeur", tempstr);

        final ArrayList<DataCard> dataCards = new ArrayList<>();
        dataCards.add(new DataCard("Brightness",lumistr + "%"));
        dataCards.add(new DataCard("Temperature",tempstr + "°C"));


        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerAdapter(dataCards);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.v("Button", "clicked");
                String dataType = dataCards.get(position).getDataName();

                if (dataType == "Temperature"){
                    Intent intent = new Intent(MainPage.this, TemperatureTableActivity.class);
                    startActivity(intent);
                }
                else if (dataType == "Brightness"){
                    Intent intent = new Intent(MainPage.this, LuminositeTableActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button refreshButton = (Button) findViewById(R.id.refreshButton);
        refreshButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(starterIntent);
            }
        });

        i = 0;

        fishList = new ArrayList<Integer>();
        fishList.add(R.drawable.ellipse_fish_1);
        fishList.add(R.drawable.blue_tang);
        fishList.add(R.drawable.clownfish);
        fishList.add(R.drawable.clarkii);
        fishList.add(R.drawable.gramma);
        nextFish = fishList.get(i);

        speciesList = new ArrayList<String>();
        speciesList.add("Yellow Tang");
        speciesList.add("Blue Tang");
        speciesList.add("Clown Anemonefish");
        speciesList.add("Clark's Anemonefish");
        speciesList.add("Royal Gramma");
        nextSpecies = speciesList.get(i);

        fishImage = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.fishImage);
        fishImage.setImageResource(nextFish);

        speciesName = (TextView) findViewById(R.id.species);
        speciesName.setText(nextSpecies);

        ImageButton rightArrow = (ImageButton) findViewById(R.id.imageButtonRight);
        rightArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i + 1;
                if (i > fishList.size() - 1){
                    i = 0;
                }
                nextFish = fishList.get(i);
                nextSpecies = speciesList.get(i);
                fishImage.setImageResource(nextFish);
                speciesName.setText(nextSpecies);
            }
        });

        ImageButton leftArrow = (ImageButton) findViewById(R.id.imageButtonLeft);
        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = i - 1;
                if (i < 0){
                    i = fishList.size() - 1;
                }
                nextFish = fishList.get(i);
                nextSpecies = speciesList.get(i);
                fishImage.setImageResource(nextFish);
                speciesName.setText(nextSpecies);
            }
        });

        Button infoButton = (Button) findViewById(R.id.infoButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainPage.this, Info_Fish_Activity.class);
                intent.putExtra("id", i);
                startActivity(intent);
            }
        });
    }
}
