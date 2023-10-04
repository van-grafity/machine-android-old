package com.app.ivansuhendra.machinegla.viewmodel;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.ivansuhendra.machinegla.model.APIResponse;
import com.app.ivansuhendra.machinegla.repository.MachineRepository;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private LiveData<APIResponse> machineResponseData;
    private MachineRepository machineRepository;

    public HomeViewModel() {
        Context context = new Activity();
        machineRepository = new MachineRepository(context);
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<APIResponse> getRemarksLiveData() {
        machineResponseData = machineRepository.getRemarksResponse();
        return machineResponseData;
    }
}