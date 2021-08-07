package com.example.musicplayer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.musicplayer.adapter.AlbumAdapter;
import com.example.musicplayer.databinding.FragmentAlbumsBinding;
import com.example.musicplayer.model.AlbumModel;

import java.util.ArrayList;
import java.util.List;


public class AlbumsFragment extends Fragment {
    List<AlbumModel> album= new ArrayList<>();
    AlbumAdapter albumAdapter;

    FragmentAlbumsBinding binding;

    public AlbumsFragment() {

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_albums,container,false);

        album.clear();
        album.add(new AlbumModel(R.drawable.music_boy, "Battle Studies", "John Mayer"));
        album.add(new AlbumModel(R.drawable.blackwaterpark, "Blackwater Park", "Opeth"));
        album.add(new AlbumModel(R.drawable.peacesellsbutwhobuying, "Peace Sells But...", "Megadeth"));
        album.add(new AlbumModel(R.drawable.americathebrutal, "Hate Crew Death", "Children Of Bodom"));
        album.add(new AlbumModel(R.drawable.masterofpuppets, "Master Of Puppets", "John Mayer"));
        album.add(new AlbumModel(R.drawable.battlestudies, "Battle Studies", "John Mayer"));

        albumAdapter = new AlbumAdapter(album, getContext());
        binding.recycles.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.recycles.setAdapter(albumAdapter);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
