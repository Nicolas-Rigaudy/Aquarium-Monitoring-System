package org.libreapps.rest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Info_Fish_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_fish);

        ArrayList<String> speciesList = new ArrayList<String>();
        ArrayList<Spanned> infoList = new ArrayList<Spanned>();

        speciesList.add("Yellow Tang");
        speciesList.add("Blue Tang");
        speciesList.add("Clown Anemonefish");
        speciesList.add("Clark's Anemonefish");
        speciesList.add("Royal Gramma");

        infoList.add(Html.fromHtml("<b>Order:</b> Perciformes<br/>" +
                "<b>Genus:</b> Zebrasoma flavescens<br/>" +
                "<b>Family:</b> Acanthuridae<br/>" +
                "<b>Descriptor:</b> Bennett, 1828<br/>" +
                "<b>Aquarium area:</b> Bottom<br/>" +
                "<b>Maintenance difficulty:</b> Amateur aquarist<br/>" +
                "<b>Food:</b> Algae, small crustaceans and zooplankton<br/>" +
                "<b>Water type:</b> Sea Water-Reef<br/>" +
                "<b>PH:</b> 7.5 to 8.5<br/>" +
                "<b>Temperature:</b> 23°C to 28°C<br/>" +
                "<b>Sociability:</b> They can be aggressive with fish brought into the aquarium after them.<br/>"));

        infoList.add(Html.fromHtml("<b>Order:</b> Perciformes<br/>" +
                "<b>Genus:</b> Paracanthurus hepatus<br/>" +
                "<b>Family:</b> Acanthuridae<br/>" +
                "<b>Descriptor:</b> Linnaeus, 1766<br/>" +
                "<b>Aquarium area:</b> Bottom to surface<br/>" +
                "<b>Maintenance difficulty:</b> Beginner<br/>" +
                "<b>Food:</b> Algae, small crustaceans and zooplankton<br/>" +
                "<b>Water type:</b> Sea Water-Reef<br/>" +
                "<b>PH:</b> 6 to 8<br/>" +
                "<b>Temperature:</b>  8°C to 24°C<br/>" +
                "<b>Sociability:</b> Pacific with all other species<br/>"));

        infoList.add(Html.fromHtml("<b>Order:</b> Perciformes<br/>" +
                "<b>Genus:</b> Amphiprion ocellaris<br/>" +
                "<b>Family:</b> Pomacentridae<br/>" +
                "<b>Descriptor:</b> Cuvier, 1830<br/>" +
                "<b>Aquarium area:</b> Top<br/>" +
                "<b>Maintenance difficulty:</b> Amateur aquarist<br/>" +
                "<b>Food:</b> Algae, small crustaceans and zooplankton<br/>" +
                "<b>Water type:</b> Sea Water-Reef<br/>" +
                "<b>PH:</b> 8.1 to 8.4<br/>" +
                "<b>Temperature:</b> 23°C to 30°C<br/>" +
                "<b>Sociability:</b> Pacific with all other species<br/>"));

        infoList.add(Html.fromHtml("Order:</b> Perciformes<br/>" +
                "<b>Genus:</b> Amphiprion clarkii<br/>" +
                "<b>Family:</b> Pomacentridae<br/>" +
                "<b>Descriptor:</b> Bennett, 1830<br/>" +
                "<b>Aquarium area:</b> Bottom<br/>" +
                "<b>Maintenance difficulty:</b> Amateur aquarist<br/>" +
                "<b>Food:</b> Algae, small crustaceans and zooplankton<br/>" +
                "<b>Water type:</b> Sea Water-Reef<br/>" +
                "<b>PH:</b> 8 to 9<br/>" +
                "<b>Temperature:</b> 22°C to 26°C<br/>" +
                "<b>Sociability:</b> Could be aggressive towards other species<br/>"));

        infoList.add(Html.fromHtml("<b>Order:</b> Perciformes<br/>" +
                "<b>Genus:</b> Gramma loreto<br/>" +
                "<b>Family:</b> Grammatidae<br/>" +
                "<b>Descriptor:</b> Poey, 1868<br/>" +
                "<b>Aquarium area:</b> Bottom<br/>" +
                "<b>Maintenance difficulty:</b> Beginner<br/>" +
                "<b>Food:</b> Small crustaceans and zooplankton<br/>" +
                "<b>Water type:</b> Sea water-Reef<br/>" +
                "<b>PH:</b> 7.5 to 8.5<br/>" +
                "<b>Temperature:</b> 23°C to 27°C<br/>" +
                "<b>Sociability:</b> Pacific with all other species<br/>"));

        int id = getIntent().getIntExtra("id", 0);

        TextView fishSpecies = (TextView) findViewById(R.id.fishSpeciesTxt);
        TextView fishInfo = (TextView) findViewById(R.id.fishInfoTxt);

        fishSpecies.setText(speciesList.get(id));
        fishInfo.setText(infoList.get(id));
    }

}
