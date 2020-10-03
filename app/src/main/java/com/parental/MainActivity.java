package com.parental;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.txtName);

        StringBuilder packageNames = new StringBuilder();
        final ActivityManager activityManager = (ActivityManager)
                getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningTaskInfo> recentTasks = Objects.requireNonNull(activityManager).getRunningTasks(Integer.MAX_VALUE);
        for (int i = 0; i < recentTasks.size(); i++) {
            packageNames.append("\n " + recentTasks.get(i).baseActivity.toShortString() + "\n\n ID: " + recentTasks.get(i).id + "");
        }
        textView.setText(packageNames.toString());
    }
}