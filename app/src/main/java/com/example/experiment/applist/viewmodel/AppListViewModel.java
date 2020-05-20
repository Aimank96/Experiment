package com.example.experiment.applist.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.experiment.applist.App;
import com.example.experiment.applist.repository.AppListRepository;

import java.util.List;

public class AppListViewModel extends AndroidViewModel {
    private AppListRepository appListRepository = new AppListRepository();
    public AppListViewModel(@NonNull Application application) {
        super(application);
    }

    public List<App> getAppList() {
        return appListRepository.getAppList(getApplication());
    }
}
