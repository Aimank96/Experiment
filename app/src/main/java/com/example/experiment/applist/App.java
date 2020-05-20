package com.example.experiment.applist;

import android.graphics.drawable.Drawable;

public class App {
    private  String appName;
    private  Drawable icon;
    private  String packages;

    public App(String appName, Drawable icon, String packages) {

        this.appName = appName;
        this.icon = icon;
        this.packages = packages;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }
}
