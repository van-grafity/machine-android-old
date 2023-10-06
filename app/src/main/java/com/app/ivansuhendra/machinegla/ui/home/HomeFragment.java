package com.app.ivansuhendra.machinegla.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.app.ivansuhendra.machinegla.adapter.MachineAdapter;
import com.app.ivansuhendra.machinegla.databinding.FragmentHomeBinding;
import com.app.ivansuhendra.machinegla.model.APIResponse;
import com.app.ivansuhendra.machinegla.model.Machine;
import com.app.ivansuhendra.machinegla.viewmodel.HomeViewModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    private MachineAdapter machineAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        binding.rvMachine.setHasFixedSize(true);
        binding.rvMachine.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        machineAdapter = new MachineAdapter(getActivity(), new MachineAdapter.itemAdapterOnClickHandler() {
            @Override
            public void onClick(Machine product, View view, int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        ArrayList<Machine> machines = new ArrayList<>();
        machines.add(new Machine("4 Needle 6 Threads Flatseamer", "Siruba"));
        machines.add(new Machine("Auto Feet Spreading", "BULLMER"));
        machines.add(new Machine("Auto Robot Cut", "TSM"));
        machines.add(new Machine("Automatic Placket Machine", "KAL"));
        machines.add(new Machine("Bartack", "Brother"));
        machines.add(new Machine("Round Knife Cutter", "Su Lee"));
        machines.add(new Machine("4 Needle 6 Threads Flatseamer", "Siruba"));
        machines.add(new Machine("Auto Feet Spreading", "BULLMER"));
        machines.add(new Machine("Auto Robot Cut", "TSM"));
        machines.add(new Machine("Automatic Placket Machine", "KAL"));
        machines.add(new Machine("Bartack", "Brother"));
        machines.add(new Machine("Round Knife Cutter", "Su Lee"));
        machines.add(new Machine("4 Needle 6 Threads Flatseamer", "Siruba"));
        machines.add(new Machine("Auto Feet Spreading", "BULLMER"));
        machines.add(new Machine("Auto Robot Cut", "TSM"));
        machines.add(new Machine("Automatic Placket Machine", "KAL"));
        machines.add(new Machine("Bartack", "Brother"));
        machines.add(new Machine("Round Knife Cutter", "Su Lee"));
        machines.add(new Machine("4 Needle 6 Threads Flatseamer", "Siruba"));
        machines.add(new Machine("Auto Feet Spreading", "BULLMER"));
        machines.add(new Machine("Auto Robot Cut", "TSM"));
        machines.add(new Machine("Automatic Placket Machine", "KAL"));
        machines.add(new Machine("Bartack", "Brother"));
        machines.add(new Machine("Round Knife Cutter", "Su Lee"));
        machines.add(new Machine("4 Needle 6 Threads Flatseamer", "Siruba"));
        machines.add(new Machine("Auto Feet Spreading", "BULLMER"));
        machines.add(new Machine("Auto Robot Cut", "TSM"));
        machines.add(new Machine("Automatic Placket Machine", "KAL"));
        machines.add(new Machine("Bartack", "Brother"));
        machines.add(new Machine("Round Knife Cutter", "Su Lee"));
        machines.add(new Machine("4 Needle 6 Threads Flatseamer", "Siruba"));
        machines.add(new Machine("Auto Feet Spreading", "BULLMER"));
        machines.add(new Machine("Auto Robot Cut", "TSM"));
        machines.add(new Machine("Automatic Placket Machine", "KAL"));
        machines.add(new Machine("Bartack", "Brother"));
        machines.add(new Machine("Round Knife Cutter", "Su Lee"));
        machines.add(new Machine("4 Needle 6 Threads Flatseamer", "Siruba"));
        machines.add(new Machine("Auto Feet Spreading", "BULLMER"));
        machines.add(new Machine("Auto Robot Cut", "TSM"));
        machines.add(new Machine("Automatic Placket Machine", "KAL"));
        machines.add(new Machine("Bartack", "Brother"));
        machines.add(new Machine("Round Knife Cutter", "Su Lee"));
        // machineAdapter.setItems(machines);
        // binding.rvMachine.setAdapter(machineAdapter);
        loadDataMachines();
        return root;
    }

//    private void loadDataMachines() {
//        homeViewModel.getMachinesLiveData(50, 2).observe(getViewLifecycleOwner(), new Observer<APIResponse>() {
//            @Override
//            public void onChanged(APIResponse apiResponse) {
//                Log.i(TAG, "onChanged: resx " + apiResponse.getData().getMachines().get(0).getMachineType().getName());
//                machineAdapter.setItems(apiResponse.getData().getMachines());
//                binding.rvMachine.setAdapter(machineAdapter);
//            }
//        });
//    }

//     public class HomeViewModel extends ViewModel {

//     private MutableLiveData<String> mText;
//     private LiveData<APIResponse> machineResponseData;
//     private MachineRepository machineRepository;
//     private LiveData<PagedList<Machine>> pagedListLiveData;
//     MachineDataSourceFactory machineDataSourceFactory;

//     public HomeViewModel() {
//         Context context = new Activity();
//         machineRepository = new MachineRepository(context);
//         mText = new MutableLiveData<>();
//         mText.setValue("This is home fragment");

//         machineDataSourceFactory = new MachineDataSourceFactory(machineRepository);
//         PagedList.Config config = (new PagedList.Config.Builder())
//                 .setEnablePlaceholders(false)
//                 .setPageSize(10)
//                 .build();
//         pagedListLiveData = (new LivePagedListBuilder(machineDataSourceFactory, config)).build();
//     }

//     public LiveData<String> getText() {
//         return mText;
//     }

//     public LiveData<APIResponse> getMachinesLiveData(int limit, int page) {
//         machineResponseData = machineRepository.getMachineResponse(limit, page);
//         return machineResponseData;
//     }

//     public LiveData<PagedList<Machine>> getPagedListLiveData() {
//         return pagedListLiveData;
//     }
// }

    public void loadDataMachines() {
        homeViewModel.getPagedListLiveData().observe(getViewLifecycleOwner(), new Observer<PagedList<Machine>>() {
            @Override
            public void onChanged(PagedList<Machine> machines) {
                machineAdapter.submitList(machines);
                binding.rvMachine.setAdapter(machineAdapter);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}