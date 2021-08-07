package com.example.musicplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.musicplayer.adapter.SongsAdapter;
import com.example.musicplayer.databinding.FragmentSongsBinding;
import com.example.musicplayer.model.SongsModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;


public class SongsFragment extends Fragment {

        FragmentSongsBinding binding;
        List<SongsModel> song = new ArrayList<>();
        SongsAdapter songsAdapter;

    BottomSheetBehavior sheetBehavior;
        LinearLayoutManager layoutManager;

        public SongsFragment() {
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_songs, container, false);

            song.clear();
            song.add(new SongsModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
            song.add(new SongsModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
            song.add(new SongsModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));
            song.add(new SongsModel(R.drawable.fearofthedark, "Fear Of The Dark", "Iron Maiden"));
            song.add(new SongsModel(R.drawable.battery, "Battery", "Metallica"));
            song.add(new SongsModel(R.drawable.ghostwalking, "Ghost Walking", "Lamb Of God"));
            song.add(new SongsModel(R.drawable.slowdancingin, "Slow Dancing In a B...", "John Mayer"));
            song.add(new SongsModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
            song.add(new SongsModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
            song.add(new SongsModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));
            song.add(new SongsModel(R.drawable.fearofthedark, "Fear Of The Dark", "Iron Maiden"));
            song.add(new SongsModel(R.drawable.battery, "Battery", "Metallica"));
            song.add(new SongsModel(R.drawable.ghostwalking, "Ghost Walking", "Lamb Of God"));
            song.add(new SongsModel(R.drawable.slowdancingin, "Slow Dancing In a B...", "John Mayer"));
            song.add(new SongsModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
            song.add(new SongsModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
            song.add(new SongsModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));
            song.add(new SongsModel(R.drawable.fearofthedark, "Fear Of The Dark", "Iron Maiden"));
            song.add(new SongsModel(R.drawable.battery, "Battery", "Metallica"));
            song.add(new SongsModel(R.drawable.ghostwalking, "Ghost Walking", "Lamb Of God"));
            song.add(new SongsModel(R.drawable.slowdancingin, "Slow Dancing In a B...", "John Mayer"));
            song.add(new SongsModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
            song.add(new SongsModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
            song.add(new SongsModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));
            song.add(new SongsModel(R.drawable.fearofthedark, "Fear Of The Dark", "Iron Maiden"));
            song.add(new SongsModel(R.drawable.battery, "Battery", "Metallica"));
            song.add(new SongsModel(R.drawable.ghostwalking, "Ghost Walking", "Lamb Of God"));
            song.add(new SongsModel(R.drawable.slowdancingin, "Slow Dancing In a B...", "John Mayer"));
            song.add(new SongsModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
            song.add(new SongsModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
            song.add(new SongsModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));
            song.add(new SongsModel(R.drawable.fearofthedark, "Fear Of The Dark", "Iron Maiden"));
            song.add(new SongsModel(R.drawable.battery, "Battery", "Metallica"));
            song.add(new SongsModel(R.drawable.ghostwalking, "Ghost Walking", "Lamb Of God"));
            song.add(new SongsModel(R.drawable.slowdancingin, "Slow Dancing In a B...", "John Mayer"));
            song.add(new SongsModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
            song.add(new SongsModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
            song.add(new SongsModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));
            song.add(new SongsModel(R.drawable.fearofthedark, "Fear Of The Dark", "Iron Maiden"));
            song.add(new SongsModel(R.drawable.battery, "Battery", "Metallica"));
            song.add(new SongsModel(R.drawable.ghostwalking, "Ghost Walking", "Lamb Of God"));
            song.add(new SongsModel(R.drawable.slowdancingin, "Slow Dancing In a B...", "John Mayer"));

            songsAdapter = new SongsAdapter(song,getContext());
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            binding.fastScrollerRecycler.setLayoutManager(layoutManager2);
            binding.fastScrollerRecycler.setItemAnimator(new DefaultItemAnimator());
            binding.fastScrollerRecycler.setAdapter(songsAdapter);
            binding.fastScrollerRecycler.setIndexBarTextColor("#DC3348");

            songsAdapter.notifyDataSetChanged();

//            sheetBehavior = BottomSheetBehavior.from(binding.nowPlayingSong.playingSong);
//            sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
//            sheetBehavior.setPeekHeight(150);
            return binding.getRoot();


        }

        @Override
        public void onDetach() {
            super.onDetach();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
        }
    }

























//    List<SongsModel> song = new ArrayList<>();
//    SongsAdapter songsAdapter;
//
//
//    FragmentLibraryBinding binding;
//
//    public SongsFragment() {
//
//    }
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_library, container, false);
//        setupViewPager(binding.viewpager);
//        binding.tabs.setupWithViewPager(binding.viewpager);
//        return binding.getRoot();
//    }
//
//    private void setupViewPager(ViewPager viewPager) {
//        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
//        adapter.addFragment(new SongsFragment(), "Songs");
//        adapter.addFragment(new AlbumsFragment(), "Albums");
//        adapter.addFragment(new ArtistsFragment(), "Artists");
//        adapter.addFragment(new GenresFragment(), "Genres");
//
//
//        viewPager.setAdapter(adapter);
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }
//}