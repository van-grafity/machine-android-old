package com.app.ivansuhendra.machinegla.net;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.app.ivansuhendra.machinegla.model.Machine;

public class MachineDataSourceFactory extends DataSource.Factory<Integer, Machine> {
    private Context mContext;
    private MutableLiveData<PageKeyedDataSource<Integer, Machine>> mMachineLiveData = new MutableLiveData<>();

    public MachineDataSourceFactory(Context context) {
        this.mContext = context;
    }

    @Override
    public DataSource<Integer, Machine> create() {
        MachineDataSource machineDataSource = new MachineDataSource(mContext);
        mMachineLiveData.postValue(machineDataSource);
        return machineDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Machine>> getMachineLiveDataSource() {
        return mMachineLiveData;
    }
}