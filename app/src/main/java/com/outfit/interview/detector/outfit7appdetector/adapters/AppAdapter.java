package com.outfit.interview.detector.outfit7appdetector.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.outfit.interview.detector.outfit7appdetector.R;
import com.outfit.interview.detector.outfit7appdetector.models.AppData;

import java.util.List;

/**
 * Created by Dejan on 18/11/2017.
 */

public class AppAdapter extends ArrayAdapter<AppData> {

    public AppAdapter(Context context, List<AppData> apps) {
        super(context, 0, apps);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // get item from position
        AppData app = getItem(position);

        // Inflate layer
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_app_data, parent, false);
        }

        // Check if view not null
        if (app == null) {
            return convertView;
        }

        // Get views
        ImageView appLogo = (ImageView) convertView.findViewById(R.id.appLogo);
        TextView appName = (TextView) convertView.findViewById(R.id.appName);
        TextView appVersion = (TextView) convertView.findViewById(R.id.appVersion);
        TextView appVersionCode = (TextView) convertView.findViewById(R.id.appVersionCode);
        TextView appPackage = (TextView) convertView.findViewById(R.id.appPackage);

        // Set view values
        appLogo.setImageDrawable(app.getApplicationLogo());
        appName.setText(app.getApplicationName());
        appVersion.setText(app.getApplicationVersion());
        appVersionCode.setText(app.getApplicationVersionCode().toString());
        appPackage.setText(app.getApplicationPackage());

        return convertView;
    }


}
