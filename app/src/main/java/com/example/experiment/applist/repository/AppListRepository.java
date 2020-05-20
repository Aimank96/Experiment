package com.example.experiment.applist.repository;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

import com.example.experiment.applist.App;

import java.util.ArrayList;
import java.util.List;

public class AppListRepository {
    public List<App> getAppList(Context context) {
        PackageManager pm = context.getPackageManager();
        List<App> apps = new ArrayList<App>();
        List<PackageInfo> packs = context.getPackageManager().getInstalledPackages(0);
        //List<PackageInfo> packs = getPackageManager().getInstalledPackages(PackageManager.GET_PERMISSIONS);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            if ((!isSystemPackage(p))) {
                String appName = p.applicationInfo.loadLabel(context.getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon(context.getPackageManager());
                String packages = p.applicationInfo.packageName;
                apps.add(new App(appName, icon, packages));
            }
        }
        return apps;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return (pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }


}
