package com.app.ivansuhendra.machinegla.model;

import com.google.gson.annotations.SerializedName;

public class MachineType {
    @SerializedName("machine_type")
    private String name;

    public String getName() {
        return name;
    }
}
