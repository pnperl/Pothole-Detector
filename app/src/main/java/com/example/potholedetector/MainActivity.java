package com.example.potholedetector;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;

// NOTE: This is a template MainActivity showing where detection and alerts integrate.
// You will need to place a working TFLite model in app/src/main/assets/detect.tflite before building.
public class MainActivity extends Activity {
    private static final String TAG = "PotholeDetector";
    private boolean useVibration = true;
    private boolean useSound = true;
    private int frameSkip = 3; // process 1 of every 3 frames
    private int frameCounter = 0;
    private Vibrator vibrator;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        mediaPlayer = MediaPlayer.create(this, R.raw.beep);

        Button settingsBtn = findViewById(R.id.btnSettings);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });

        // TODO: Initialize camera preview and TFLite interpreter here.
        // Use a background thread for inference and apply frame skipping (frameSkip variable).
        Log.i(TAG, "App started. Place detect.tflite in assets to enable detection.");
    }

    // Call this when detection confidence exceeds threshold
    private void onPotholeDetected() {
        Log.i(TAG, "Pothole detected");
        if (useVibration && vibrator != null) {
            vibrator.vibrate(200);
        }
        if (useSound && mediaPlayer != null) {
            mediaPlayer.start();
        }
    }
}
