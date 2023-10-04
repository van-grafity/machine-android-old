package com.app.ivansuhendra.machinegla.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class APIModels {
    @SerializedName("cutting_record_remark")
    private ArrayList<CuttingRecordRemark> cuttingRecordRemarks;

    public ArrayList<CuttingRecordRemark> getCuttingRecordRemarks() {
        return cuttingRecordRemarks;
    }
}
