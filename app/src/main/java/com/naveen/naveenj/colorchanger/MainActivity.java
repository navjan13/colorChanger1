package com.naveen.naveenj.colorchanger;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int r=250, g=250, b=250;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getApplicationContext().getSharedPreferences("myPrefsKey_rgb", Context.MODE_PRIVATE);
        editor = prefs.edit();
        r = prefs.getInt("r", -1);
        g = prefs.getInt("g", -1);
        b = prefs.getInt("b", -1);
        if (r == -1 || g == -1 || b == -1) {
            editor.putInt("r", 250);
            editor.putInt("g", 250);
            editor.putInt("b", 250);
            editor.commit();
        }
        seebar();
        Button button4 = (Button) findViewById(R.id.saveColor);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("r", r);
                editor.putInt("g", g);
                editor.putInt("b", b);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Color Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void seebar() {
        SeekBar s1,s2,s3;
        View someView = findViewById(R.id.screen);
        View root = someView.getRootView();
        s1 = (SeekBar)findViewById(R.id.seekBarRed);
        s2 = (SeekBar)findViewById(R.id.seekBarBlue);
        s3 = (SeekBar)findViewById(R.id.seekBarGreen);
        r = prefs.getInt("r", 250);
        g = prefs.getInt("g", 250);
        b = prefs.getInt("b", 250);
        s1.setProgress(r);
        s2.setProgress(b);
        s3.setProgress(g);
        root.setBackgroundColor(Color.argb(255, r, g, b));

        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                View someView = findViewById(R.id.screen);
                View root = someView.getRootView();
                r = progress;
                root.setBackgroundColor(Color.argb(255, r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                View someView = findViewById(R.id.screen);
                View root = someView.getRootView();
                b = progress;
                root.setBackgroundColor(Color.argb(255, r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        s3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                View someView = findViewById(R.id.screen);
                View root = someView.getRootView();
                g = progress;
                root.setBackgroundColor(Color.argb(255, r, g, b));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
