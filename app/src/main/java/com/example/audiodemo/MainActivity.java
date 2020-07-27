package com.example.audiodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    MediaPlayer a;
    AudioManager audioManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         a = MediaPlayer.create(this,R.raw.song);
         audioManager= (AudioManager) getSystemService(AUDIO_SERVICE);
         int maxvolume= audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
         int currentvolume= audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        SeekBar vc = (SeekBar) findViewById(R.id.seekBar);
        vc.setProgress(currentvolume);
        vc.setMax(maxvolume);
        vc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public void play(View view){

        a.start();
    }
    public void pause(View view){

        a.pause();
    }
}
