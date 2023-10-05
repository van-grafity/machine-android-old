package com.app.ivansuhendra.machinegla.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.app.ivansuhendra.machinegla.model.APIResponse;
import com.app.ivansuhendra.machinegla.net.API;
import com.app.ivansuhendra.machinegla.net.APICallback;
import com.app.ivansuhendra.machinegla.net.BadRequest;

public class MachineRepository {
    private Context mContext;

    public MachineRepository(Context context) {
        this.mContext = context;
    }

    public LiveData<APIResponse> getMachineResponse(int limit, int page) {
        final MutableLiveData<APIResponse> mutableLiveData = new MutableLiveData<>();
        API.service().getMachine(limit, page).enqueue(new APICallback<APIResponse>(mContext) {
            @Override
            protected void onSuccess(APIResponse apiResponse) {
                mutableLiveData.setValue(apiResponse);
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });
        return mutableLiveData;
    }
}
