package com.outfit.interview.detector.outfit7appdetector.models;

import android.graphics.drawable.Drawable;

/**
 * Created by Dejan on 18/11/2017.
 */

public class AppData {

    private String applicationName;

    private Integer applicationVersionCode;

    private String applicationVersionName;

    private Drawable applicationLogo;

    private String applicationPackage;

    public AppData(String applicationName, Integer applicationVersionCode, String applicationVersionName, Drawable applicationLogo, String applicationPackage) {
        this.applicationName = applicationName;
        this.applicationVersionCode = applicationVersionCode;
        this.applicationVersionName = applicationVersionName;
        this.applicationLogo = applicationLogo;
        this.applicationPackage = applicationPackage;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public Integer getApplicationVersionCode() {
        return applicationVersionCode;
    }

    public void setApplicationVersionCode(Integer applicationVersionCode) {
        this.applicationVersionCode = applicationVersionCode;
    }

    public String getApplicationVersionName() {
        return applicationVersionName;
    }

    public void setApplicationVersionName(String applicationVersionName) {
        this.applicationVersionName = applicationVersionName;
    }

    public Drawable getApplicationLogo() {
        return applicationLogo;
    }

    public void setApplicationLogo(Drawable applicationLogo) {
        this.applicationLogo = applicationLogo;
    }

    public String getApplicationPackage() {
        return applicationPackage;
    }

    public void setApplicationPackage(String applicationPackage) {
        this.applicationPackage = applicationPackage;
    }
}
