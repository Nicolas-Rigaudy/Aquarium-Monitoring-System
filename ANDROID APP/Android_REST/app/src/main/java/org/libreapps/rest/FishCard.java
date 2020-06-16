package org.libreapps.rest;

public class FishCard {
    private String mImageResource;
    private String mSpecies;

    public FishCard(String imageResource, String species){
        mImageResource = imageResource;
        mSpecies = species;
    }

    public String getImageResource() {
        return mImageResource;
    }

    public String getSpecies() {
        return mSpecies;
    }
}
