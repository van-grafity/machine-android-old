package com.app.ivansuhendra.machinegla.net;

import com.app.ivansuhendra.machinegla.model.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface APIService {
    @GET("machine")
    Call<APIResponse> getMachine(@Query("limit") int limit, @Query("offset") int page);
}
