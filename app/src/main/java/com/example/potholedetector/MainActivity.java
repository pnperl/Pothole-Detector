package com.example.potholedetector;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity {
    private static final String TAG = "PotholeDetector";
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
            @Override public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        Log.i(TAG, "App started. detect.tflite must be present in assets.");
    }
    private void onPotholeDetected() {
        if (vibrator != null) vibrator.vibrate(200);
        if (mediaPlayer != null) mediaPlayer.start();
    }
}
