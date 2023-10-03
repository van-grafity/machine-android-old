package com.app.ivansuhendra.machinegla.model;

public class APIResponse {
    private int status;
    private String message;
    private APIModels data;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public APIModels getData() {
        return data;
    }
}
