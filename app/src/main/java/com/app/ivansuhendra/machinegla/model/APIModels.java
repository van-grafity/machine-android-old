package com.app.ivansuhendra.machinegla.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class APIModels {
    @SerializedName("machines")
    private ArrayList<Machine> machines;

    public ArrayList<Machine> getMachines() {
        return machines;
    }
}
