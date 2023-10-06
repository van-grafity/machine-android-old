package com.app.ivansuhendra.machinegla.net;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.paging.PageKeyedDataSource;

import com.app.ivansuhendra.machinegla.model.APIResponse;
import com.app.ivansuhendra.machinegla.model.Machine;
import com.app.ivansuhendra.machinegla.repository.MachineRepository;

public class MachineDataSource extends PageKeyedDataSource<Integer, Machine> {
    private static final String TAG = "MachineDataSource";
    
    private MachineRepository mMachineRepository;
    private Context mContext;

    private static final int PAGE_SIZE = 10;
    private static final int FIRST_PAGE = 1;
    
    public MachineDataSource(Context context) {
        this.mContext = context;
        this.mMachineRepository = new MachineRepository(mContext);
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Machine> callback) {
        API.service().getMachine(PAGE_SIZE, FIRST_PAGE).enqueue(new APICallback<APIResponse>(mContext) {
            @Override
            protected void onSuccess(APIResponse apiResponse) {
                callback.onResult(apiResponse.getData().getMachines(), null, FIRST_PAGE + 1);
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Machine> callback) {
        API.service().getMachine(PAGE_SIZE, params.key).enqueue(new APICallback<APIResponse>(mContext) {
            @Override
            protected void onSuccess(APIResponse apiResponse) {
                Integer key = (params.key > 1) ? params.key - 1 : null;
                callback.onResult(apiResponse.getData().getMachines(), key);
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });
    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Machine> callback) {
        API.service().getMachine(PAGE_SIZE, params.key).enqueue(new APICallback<APIResponse>(mContext) {
            @Override
            protected void onSuccess(APIResponse apiResponse) {
                Integer key = apiResponse.getData().getMachines().size() > 0 ? params.key + 1 : null;
                callback.onResult(apiResponse.getData().getMachines(), key);
            }

            @Override
            protected void onError(BadRequest error) {

            }
        });
    }
}