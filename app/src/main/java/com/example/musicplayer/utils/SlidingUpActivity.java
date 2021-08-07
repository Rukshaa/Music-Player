package com.example.musicplayer.utils;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.musicplayer.R;
import com.example.musicplayer.databinding.SlidinguppanelLayoutBinding;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class SlidingUpActivity extends AppCompatActivity {
SlidinguppanelLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                DataBindingUtil.setContentView(this, R.layout.slidinguppanel_layout);
        binding.slidingLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                binding.slidingLayout.setAlpha(1-slideOffset);
            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

                if (newState ==SlidingUpPanelLayout.PanelState.EXPANDED)
                    Toast.makeText(SlidingUpActivity.this, "Panel expanded", Toast.LENGTH_SHORT).show();
                else if(newState == SlidingUpPanelLayout.PanelState.COLLAPSED)
                    Toast.makeText(SlidingUpActivity.this, "Panel collapsed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

