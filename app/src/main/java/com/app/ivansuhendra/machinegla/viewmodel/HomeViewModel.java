package com.app.ivansuhendra.machinegla.viewmodel;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.app.ivansuhendra.machinegla.model.APIResponse;
import com.app.ivansuhendra.machinegla.model.Machine;
import com.app.ivansuhendra.machinegla.net.MachineDataSource;
import com.app.ivansuhendra.machinegla.net.MachineDataSourceFactory;
import com.app.ivansuhendra.machinegla.repository.MachineRepository;

import javax.crypto.Mac;

// public class MachineDataSourceFactory extends DataSource.Factory<Integer, Machine> {
//     private MachineRepository mMachineRepository;
//     private MutableLiveData<PageKeyedDataSource<Integer, Machine>> mMachineLiveData = new MutableLiveData<>();

//     public MachineDataSourceFactory(MachineRepository machineRepository) {
//         this.mMachineRepository = machineRepository;
//     }

//     @Override
//     public DataSource<Integer, Machine> create() {
//         MachineDataSource machineDataSource = new MachineDataSource(mMachineRepository);
//         mMachineLiveData.postValue(machineDataSource);
//         return machineDataSource;
//     }

//     public MutableLiveData<PageKeyedDataSource<Integer, Machine>> getMachineLiveDataSource() {
//         return mMachineLiveData;
//     }
// }

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private LiveData<APIResponse> machineResponseData;
    private MachineRepository machineRepository;
    private LiveData<PagedList<Machine>> pagedListLiveData;
    LiveData<PageKeyedDataSource<Integer, Machine>> liveDataSource;
    MachineDataSourceFactory machineDataSourceFactory;

    public HomeViewModel() {
        Context context = new Activity();
        machineRepository = new MachineRepository(context);
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        machineDataSourceFactory = new MachineDataSourceFactory(context);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<APIResponse> getMachinesLiveData(int limit, int page) {
        machineResponseData = machineRepository.getMachineResponse(limit, page);
        return machineResponseData;
    }

    public LiveData<PagedList<Machine>> getPagedListLiveData() {
        liveDataSource = machineDataSourceFactory.getMachineLiveDataSource();

        PagedList.Config config = (new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build();

        pagedListLiveData = (new LivePagedListBuilder(machineDataSourceFactory, config)).build();
        return pagedListLiveData;
    }
}