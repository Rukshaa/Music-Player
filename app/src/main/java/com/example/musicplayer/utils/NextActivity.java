package com.example.musicplayer.utils;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.musicplayer.MainActivity;
import com.example.musicplayer.R;
import com.example.musicplayer.databinding.ActivityNextBinding;

public class NextActivity extends AppCompatActivity {
    ActivityNextBinding binding;
    MediaPlayer mediaPlayer;
    boolean play, back, reactImg, speakerMute;
    int progess;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_next);

            audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
            int maxVolume=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            int currentVolume=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


            binding.react.setOnClickListener(v -> {
                if (reactImg) {
                    binding.react.setImageResource(R.drawable.react_color);
                    reactImg = false;
                } else {
                    binding.react.setImageResource(R.drawable.ic_react1);
                    reactImg = true;
                }
            });

            binding.playImg.setOnClickListener(v -> {
                if (play) {
                    binding.playImg.setImageResource(R.drawable.ic_pause);
                    play = false;
                } else {
                    binding.playImg.setImageResource(R.drawable.ic_play1);
                    play = true;
                }
            });

            binding.playback.setOnClickListener(v -> {
                if (back) {
                    binding.playback.setImageResource(R.drawable.backarrowwhite1);
                    play = false;
                } else {
                    binding.playback.setImageResource(R.drawable.ic_backarrow1);
                    back = true;
                }
            });

            binding.playback.setOnClickListener(v ->
            { startActivity(new Intent(getApplicationContext(), MainActivity.class));

            });

            binding.songTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
            binding.songTitle.setSelected(true);
            binding.songTitle.setSingleLine(true);
            binding.songTitle.setText("Slow Dancing In A Burning  Slow Dancing In A Burning...");

            binding.volumeImg.setOnClickListener(v -> {
                binding.volumeSection.setVisibility(View.VISIBLE);
                binding.playTime.setVisibility(View.GONE);
                binding.volumeImg.setVisibility(View.GONE);
                binding.speakerSection.setVisibility(View.VISIBLE);

                new Handler().postDelayed((Runnable) () -> {

                    binding.volumeSection.setVisibility(View.GONE);
                    binding.playTime.setVisibility(View.VISIBLE);
                    binding.volumeImg.setVisibility(View.VISIBLE);
                    binding.speakerSection.setVisibility(View.GONE);
                }, 3000);
            });

            binding.muteVolume.setOnClickListener(v -> {
                if (binding.volumebar.getProgress() > 0) {
                    binding.volumebar.setProgress(0);
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumebar.getProgress(), AudioManager.FLAG_SHOW_UI);
                }
            });
            binding.highVolume.setOnClickListener(v -> {
                if (binding.volumebar.getProgress() < audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)) {
//                binding.volumebar.setProgress(binding.volumebar.getProgress() + 1);
                    binding.volumebar.setProgress(100);
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumebar.getProgress(), AudioManager.FLAG_SHOW_UI);
                }
            });
            binding.volumebar.setMax(maxVolume);
            binding.volumebar.setProgress(currentVolume);
            binding.volumebar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progess,0);

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });


        }

        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
            int action = event.getAction();
            int keyCode = event.getKeyCode();
            switch (keyCode) {
                case KeyEvent.KEYCODE_VOLUME_UP:
                    if (action == KeyEvent.ACTION_UP) {
                        binding.volumeSection.setVisibility(View.VISIBLE);
                        binding.playTime.setVisibility(View.GONE);
                        binding.volumeImg.setVisibility(View.GONE);
                        binding.speakerSection.setVisibility(View.VISIBLE);

                        if (binding.volumebar.getProgress() < audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)) {
                            binding.volumebar.setProgress(binding.volumebar.getProgress() + 1);
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumebar.getProgress(), AudioManager.FLAG_SHOW_UI);
                        }
                        new Handler().postDelayed((Runnable) () -> {

                            binding.volumeSection.setVisibility(View.GONE);
                            binding.playTime.setVisibility(View.VISIBLE);
                            binding.volumeImg.setVisibility(View.VISIBLE);
                            binding.speakerSection.setVisibility(View.GONE);
                        }, 3000);
                    }
                    return true;
                case KeyEvent.KEYCODE_VOLUME_DOWN:
                    if (action == KeyEvent.ACTION_DOWN) {
                        binding.volumeSection.setVisibility(View.VISIBLE);
                        binding.playTime.setVisibility(View.GONE);
                        binding.volumeImg.setVisibility(View.GONE);
                        binding.speakerSection.setVisibility(View.VISIBLE);

                        if (binding.volumebar.getProgress() > 0) {
                            binding.volumebar.setProgress(binding.volumebar.getProgress() - 1);
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumebar.getProgress(), AudioManager.FLAG_SHOW_UI);
                        }
                        new Handler().postDelayed((Runnable) () -> {

                            binding.volumeSection.setVisibility(View.GONE);
                            binding.playTime.setVisibility(View.VISIBLE);
                            binding.volumeImg.setVisibility(View.VISIBLE);
                            binding.speakerSection.setVisibility(View.GONE);

                        }, 3000);
                    }
                    return true;
                default:
                    return super.dispatchKeyEvent(event);
            }
        }
    }


