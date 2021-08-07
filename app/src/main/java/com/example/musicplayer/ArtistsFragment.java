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

import com.example.musicplayer.adapter.ArtistsAdapter;
import com.example.musicplayer.databinding.FragmentArtistsBinding;
import com.example.musicplayer.model.ArtistsModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;


public class ArtistsFragment extends Fragment {

        FragmentArtistsBinding binding;
        List<ArtistsModel> artist = new ArrayList<>();
        ArtistsAdapter artistsAdapter;

        BottomSheetBehavior sheetBehavior;
        LinearLayoutManager layoutManager;

        public ArtistsFragment() {
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_artists, container, false);

            artist.clear();
            artist.add(new ArtistsModel(R.drawable.childrenofbodomcircle, "Children Of Bodom", "Albums:1,Songs:100 "));
            artist.add(new ArtistsModel(R.drawable.megadethcircle, "Megadeth", "Albums:4,Songs:100"));
            artist.add(new ArtistsModel(R.drawable.metallicacircle, "Metallica", "Albums:5,Songs:150"));
            artist.add(new ArtistsModel(R.drawable.nirvanacircle, "Nirvana", "Albums:3,Songs:100"));
            artist.add(new ArtistsModel(R.drawable.opethcircle, "Plini", "Albums:1,Songs:100"));
            artist.add(new ArtistsModel(R.drawable.plinicircle, "Rage Against The Machine", "Albums:11,Songs:100"));
            artist.add(new ArtistsModel(R.drawable.rathmcircle, "America The Brutal", "Albums:2,Songs:100"));
            artist.add(new ArtistsModel(R.drawable.childrenofbodomcircle, "Plini", "Albums:5,Songs:100"));

            artist.add(new ArtistsModel(R.drawable.childrenofbodomcircle, "Children Of Bodom", "Albums:1,Songs:100 "));
            artist.add(new ArtistsModel(R.drawable.megadethcircle, "Megadeth", "Albums:4,Songs:100"));
            artist.add(new ArtistsModel(R.drawable.metallicacircle, "Metallica", "Albums:5,Songs:150"));
            artist.add(new ArtistsModel(R.drawable.nirvanacircle, "Nirvana", "Albums:3,Songs:100"));
            artist.add(new ArtistsModel(R.drawable.opethcircle, "Plini", "Albums:1,Songs:100"));

            ArtistsAdapter recyclerViewAdapter = new ArtistsAdapter(artist,getContext());
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            binding.fastScrollerRecyclers.setLayoutManager(layoutManager2);
            binding.fastScrollerRecyclers.setItemAnimator(new DefaultItemAnimator());
            binding.fastScrollerRecyclers.setAdapter(recyclerViewAdapter);
            binding.fastScrollerRecyclers.setIndexBarTextColor("#DC3348");
            recyclerViewAdapter.notifyDataSetChanged();

//            sheetBehavior = BottomSheetBehavior.from(binding.nowPlayingSong.playingSong);
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

















