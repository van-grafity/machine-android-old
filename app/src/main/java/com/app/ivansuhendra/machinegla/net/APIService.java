package com.app.ivansuhendra.machinegla.net;

import com.app.ivansuhendra.machinegla.model.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface APIService {
    @GET("cutting-record-remark")
    Call<APIResponse> getRemarks();
}
