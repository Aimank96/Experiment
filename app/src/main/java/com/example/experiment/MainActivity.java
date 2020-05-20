package com.example.experiment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.experiment.applist.App;
import com.example.experiment.applist.adapter.AppListAdapter;
import com.example.experiment.applist.viewmodel.AppListViewModel;
import com.example.experiment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private AppListViewModel appListViewModel;

    private AppListAdapter appListAdapter = new AppListAdapter();
    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        appListViewModel = new ViewModelProvider(this).get(AppListViewModel.class);

        appListAdapter.setOnSelectedCallBack(new AppListAdapter.OnSelectedCallBack() {
            @Override
            public void onSelectedCallBack(App app) {
                
            }
        });


        binding.rvApp.setLayoutManager(new LinearLayoutManager(this));
        appListAdapter.setAppList(appListViewModel.getAppList());
        binding.rvApp.setAdapter(appListAdapter);


    }
}
