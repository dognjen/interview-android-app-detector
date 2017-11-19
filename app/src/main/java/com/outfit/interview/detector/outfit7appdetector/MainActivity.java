package com.outfit.interview.detector.outfit7appdetector;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.outfit.interview.detector.outfit7appdetector.adapters.AppAdapter;
import com.outfit.interview.detector.outfit7appdetector.models.AppData;
import com.outfit.interview.detector.outfit7appdetector.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static PackageManager pm;

    private List<AppData> listOfApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize values
        listOfApps = new ArrayList<>();
        pm = getPackageManager();

        // find applications
        findApplications();
    }

    public void refresh(View view) {
        listOfApps = new ArrayList<>();

        findApplications();
    }

    private void findApplications() {

        // get all installed applications
        List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

        try {
            for (ApplicationInfo packageInfo : packages) {

                // remove system apps and pre-installed apps
                // get only outfit7 apps
                String pckg = packageInfo.packageName;
                if ((packageInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
                    continue;
                } else if ((packageInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) {
                    continue;
                } else if (!pckg.startsWith(AppUtils.OUTFIT7_PACKAGE)) {
                    continue;
                }

                //
                AppData app = new AppData(
                        pm.getApplicationLabel(packageInfo).toString(),
                        pm.getPackageInfo(pckg, 0).versionCode,
                        pm.getPackageInfo(pckg, 0).versionName,
                        pm.getApplicationIcon(packageInfo),
                        pckg
                );

                listOfApps.add(app);
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.d(AppUtils.INTERNAL_ERROR, "Name was not found.");
        }

        AppAdapter appAdapter = new AppAdapter(this, listOfApps);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(appAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                AppData app = listOfApps.get(position);

                Intent launchIntent = pm.getLaunchIntentForPackage(app.getApplicationPackage());

                if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Log.d(AppUtils.INTERNAL_ERROR, "Could not start application " + app.getApplicationName());
                }
            }
        });

    }
}
