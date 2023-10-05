package com.app.ivansuhendra.machinegla.model;

import com.google.gson.annotations.SerializedName;

public class Machine {
    private String model;
    @SerializedName("serial_number")
    private String serialNumber;

    @SerializedName("machine_type")
    private MachineType machineType;

    private Brand brand;

    public Machine(String model, String serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public Brand getBrand() {
        return brand;
    }
}