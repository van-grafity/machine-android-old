package com.app.ivansuhendra.machinegla.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.app.ivansuhendra.machinegla.databinding.FragmentHomeBinding;
import com.app.ivansuhendra.machinegla.model.APIResponse;
import com.app.ivansuhendra.machinegla.net.API;
import com.app.ivansuhendra.machinegla.viewmodel.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        loadDataRemarks();
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;
    }

    private void loadDataRemarks() {
        homeViewModel.getRemarksLiveData().observe(getViewLifecycleOwner(), new Observer<APIResponse>() {
            @Override
            public void onChanged(APIResponse apiResponse) {
                Log.i(TAG, "onChanged: resx " + apiResponse.getData().getCuttingRecordRemarks());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}