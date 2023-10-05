package com.app.ivansuhendra.machinegla.model;

public class APIResponse {
    private boolean status;
    private String message;
    private APIModels data;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public APIModels getData() {
        return data;
    }
}
