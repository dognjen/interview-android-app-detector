package com.outfit.interview.detector.outfit7appdetector.models;

import android.graphics.drawable.Drawable;

/**
 * Created by Dejan on 18/11/2017.
 */

public class AppData {

    private String applicationName;

    private Integer applicationVersionCode;

    private String applicationVersion;

    private Drawable applicationLogo;

    private String applicationPackage;

    public AppData(String applicationName, Integer applicationVersionCode, String applicationVersion, Drawable applicationLogo, String applicationPackage) {
        this.applicationName = applicationName;
        this.applicationVersionCode = applicationVersionCode;
        this.applicationVersion = applicationVersion;
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

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
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
