package com.example.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.example.musicplayer.dashboard.DashboardActivity;
import com.example.musicplayer.databinding.ActivityMainBinding;
import com.example.musicplayer.utils.RoundedTransformation;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MediaPlayer mediaPlayer;
    ActivityMainBinding binding;
    boolean play, back, reactImg, speakerMute, forward;

    private AudioManager audioManager;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.swipe.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), DashboardActivity.class)));

        audioManager = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        Picasso.with(getApplicationContext())
                .load(R.drawable.music_boy)
                .transform(new RoundedTransformation(10, 0))
                .into(binding.imgAlbumArt);


        binding.react.setOnClickListener(v -> {
            if (reactImg) {
                binding.react.setImageResource(R.drawable.react_color);
                reactImg = false;
            } else {
                binding.react.setImageResource(R.drawable.ic_react1);
                reactImg = true;
            }
        });

        binding.btnPlay.setOnClickListener(this);

        binding.playback.setOnClickListener(v -> {
            if (back) {
                binding.playback.setImageResource(R.drawable.backarrowwhite1);
                play = false;
            } else {
                binding.playback.setImageResource(R.drawable.ic_backarrow1);
                back = true;
            }
        });




        binding.playForward.setOnClickListener(v -> {
            binding.cardView.setCardBackgroundColor(Color.parseColor("#888888"));
            binding.imgAlbumArt.setVisibility(View.GONE);
            binding.musicLogo.setVisibility(View.VISIBLE);
            binding.singerName.setText("Michael");
            binding.battleStudies.setText("Ram Studies");
            binding.songTitle.setText("Slow Motions");
            binding.playForward.setEnabled(false);
            binding.playback.setEnabled(true);
            binding.playback.setColorFilter(ContextCompat.getColor(this, R.color.white));
            binding.playForward.setColorFilter(ContextCompat.getColor(this, R.color.dark_grey));

        });

        binding.playback.setOnClickListener(v -> {
            binding.imgAlbumArt.setVisibility(View.VISIBLE);
            binding.singerName.setText("John Mayer");
            binding.musicLogo.setVisibility(View.GONE);
            binding.battleStudies.setText("Battle Studies");
            binding.songTitle.setText("Slow Dancing In A Burning Slow Dancing In A Burning...");
            binding.playForward.setEnabled(true);
            binding.playback.setEnabled(false);
            binding.playback.setColorFilter(ContextCompat.getColor(this, R.color.dark_grey));
            binding.playForward.setColorFilter(ContextCompat.getColor(this, R.color.white));

        });

//for marquee text(sliding the text)
        binding.songTitle.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        binding.songTitle.setSelected(true);
        binding.songTitle.setSingleLine(true);
        binding.songTitle.setText("Slow Dancing In A Burning Slow Dancing In A Burning...");


        binding.volumeImg.setOnClickListener(this);
        binding.muteVolume.setOnClickListener(v -> {
            if (binding.volumeSeekbar.getProgress() > 0) {
                binding.volumeSeekbar.setProgress(0);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumeSeekbar.getProgress(), AudioManager.FLAG_SHOW_UI);
            }
        });
        binding.highVolume.setOnClickListener(v -> {
            if (binding.volumeSeekbar.getProgress() < audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)) {
                binding.volumeSeekbar.setProgress(100);
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumeSeekbar.getProgress(), AudioManager.FLAG_SHOW_UI);
            }
        });
        binding.volumeSeekbar.setMax(maxVolume);
        binding.volumeSeekbar.setProgress(currentVolume);
        binding.volumeSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 2000);

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

                    if (binding.volumeSeekbar.getProgress() < audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)) {
                        binding.volumeSeekbar.setProgress(binding.volumeSeekbar.getProgress() + 1);
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumeSeekbar.getProgress(), AudioManager.FLAG_SHOW_UI);
                    }
                    showVolumeControl();
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_DOWN) {
                    if (binding.volumeSeekbar.getProgress() > 0) {
                        binding.volumeSeekbar.setProgress(binding.volumeSeekbar.getProgress() - 1);
                        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, binding.volumeSeekbar.getProgress(), AudioManager.FLAG_SHOW_UI);
                    }
                    showVolumeControl();
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }

    }

    Handler handler;
    Runnable runnable = (Runnable) () -> {
        binding.volumeSection.setVisibility(View.GONE);
        binding.playTime.setVisibility(View.VISIBLE);
        binding.volumeImg.setVisibility(View.VISIBLE);
        binding.speakerSection.setVisibility(View.GONE);
    };

    @Override
    public void onClick(View v) {
        if (v == binding.volumeImg) {
            showVolumeControl();
        } else if (v == binding.btnPlay) {
            binding.btnPlay.setImageResource(play ? R.drawable.pause : R.drawable.ic_play1);
            play = !play;
        }
    }

    private void showVolumeControl() {
        binding.volumeSection.setVisibility(View.VISIBLE);
        binding.playTime.setVisibility(View.GONE);
        binding.volumeImg.setVisibility(View.GONE);
        binding.speakerSection.setVisibility(View.VISIBLE);
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        } else {
            handler = new Handler();
        }
        handler.postDelayed(runnable, 3000);
    }
}
















//binding.swipe.setOnTouchListener(new View.OnTouchListener() {
//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
//        return false;
//    }
//});

