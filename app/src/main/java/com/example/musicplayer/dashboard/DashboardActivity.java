package com.example.musicplayer.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.musicplayer.LibraryFragment;
import com.example.musicplayer.MainActivity;
import com.example.musicplayer.R;
import com.example.musicplayer.SearchFragment;
import com.example.musicplayer.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

public class DashboardActivity extends AppCompatActivity {
    ActivityDashboardBinding binding;
    private BottomSheetBehavior sheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =
                DataBindingUtil.setContentView(this, R.layout.activity_dashboard);

//        binding.slidingLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener()
//        {
//            @Override
//            public void onPanelSlide(View panel, float slideOffset) {
//                binding.slidingLayout.setAlpha(1-slideOffset);
//            }
//
//            @Override
//            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
//
//                if (newState ==SlidingUpPanelLayout.PanelState.EXPANDED)
//                    Toast.makeText(DashboardActivity.this, "Panel expanded", Toast.LENGTH_SHORT).show();
//                else if(newState == SlidingUpPanelLayout.PanelState.COLLAPSED)
//                    Toast.makeText(DashboardActivity.this, "Panel collapsed", Toast.LENGTH_SHORT).show();
//            }
//        });

        loadFragment(new LibraryFragment());
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        sheetBehavior = BottomSheetBehavior.from(binding.playingSong);
        if (sheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            if (sheetBehavior instanceof LockableBottomSheetBehavior) {
                ((LockableBottomSheetBehavior) sheetBehavior).setLocked(true);
            }
        }
        sheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        Fragment fragment;
        switch (item.getItemId()) {
            case R.id.actionBrowse:
                fragment = new LibraryFragment();
                loadFragment(fragment);
                return true;
            case R.id.actionLibrary:
                fragment = new LibraryFragment();
                loadFragment(fragment);
                return true;
            case R.id.actionSearch:
                fragment = new SearchFragment();
                loadFragment(fragment);
                return true;
            case R.id.actionPlaylists:
                fragment = new LibraryFragment();
                loadFragment(fragment);
                return true;
        }
        return false;
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);

        //goes to back at once
        transaction.detach(fragment).attach(fragment).commit();

        binding.cardMusic.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));


    }

}
