package com.example.potholedetector;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final SharedPreferences prefs = getSharedPreferences("pothole_prefs", MODE_PRIVATE);
        Switch swVib = findViewById(R.id.swVibration);
        Switch swSound = findViewById(R.id.swSound);

        swVib.setChecked(prefs.getBoolean("vibration", true));
        swSound.setChecked(prefs.getBoolean("sound", true));

        swVib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prefs.edit().putBoolean("vibration", isChecked).apply();
            }
        });
        swSound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                prefs.edit().putBoolean("sound", isChecked).apply();
            }
        });
    }
}
