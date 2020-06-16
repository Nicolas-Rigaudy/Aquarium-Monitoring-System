package org.libreapps.rest;

public class DataCard {
    private String mDataName;
    private String mDataValue;

    public DataCard(String dataName, String dataValue){
        mDataName = dataName;
        mDataValue = dataValue;
    }

    public String getDataName() {
        return mDataName;
    }

    public String getDataValue() {
        return mDataValue;
    }
}

