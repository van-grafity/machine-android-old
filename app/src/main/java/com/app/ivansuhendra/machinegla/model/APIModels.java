package com.app.ivansuhendra.machinegla.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class APIModels {
    @SerializedName("cutting_order_records")
    private ArrayList<CuttingOrderRecord> cuttingOrderRecords;

    public ArrayList<CuttingOrderRecord> getCuttingOrderRecords() {
        return cuttingOrderRecords;
    }

    public void setCuttingOrderRecords(ArrayList<CuttingOrderRecord> cuttingOrderRecords) {
        this.cuttingOrderRecords = cuttingOrderRecords;
    }
}
