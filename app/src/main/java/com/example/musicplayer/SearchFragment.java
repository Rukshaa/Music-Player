package com.example.musicplayer;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.musicplayer.adapter.AlbumAdapter;
import com.example.musicplayer.adapter.ArtistsAdapter;
import com.example.musicplayer.adapter.SongsAdapter;
import com.example.musicplayer.databinding.FragmentSearchBinding;
import com.example.musicplayer.model.AlbumModel;
import com.example.musicplayer.model.ArtistsModel;
import com.example.musicplayer.model.SongsModel;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

//    List<SearchModel> search = new ArrayList<>();
//    SearchAdapter searchAdapter;

    List<SongsModel> song = new ArrayList<>();
    SongsAdapter songsAdapter;

    List<ArtistsModel> artist = new ArrayList<>();
    ArtistsAdapter artistsAdapter;

    List<AlbumModel> album= new ArrayList<>();
    AlbumAdapter albumAdapter;
    FragmentSearchBinding binding;

    public SearchFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_search, container, false);
//        search.add(new SearchModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
//        search.add(new SearchModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
//        search.add(new SearchModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));
//
//        searchAdapter = new SearchAdapter(search, getContext());
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        binding.songList.setLayoutManager(layoutManager);
//        binding.songList.setAdapter(searchAdapter);

        song.add(new SongsModel(R.drawable.americathebrutal, "America The Brutal", "Six Feet Under"));
        song.add(new SongsModel(R.drawable.sixpounder, "Six Pounder", "Children Of Bodom"));
        song.add(new SongsModel(R.drawable.electricsunrise, "Eletric Sunrise", "Plini"));

        songsAdapter = new SongsAdapter(song,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.songList.setLayoutManager(layoutManager);
        binding.songList.setAdapter(songsAdapter);


        artist.clear();
        artist.add(new ArtistsModel(R.drawable.childrenofbodomcircle, "Children Of Bodom", "Albums:1,Songs:100 "));
        artist.add(new ArtistsModel(R.drawable.megadethcircle, "Megadeth", "Albums:4,Songs:100"));
        artist.add(new ArtistsModel(R.drawable.metallicacircle, "Metallica", "Albums:5,Songs:150"));

        artistsAdapter = new ArtistsAdapter(artist, getContext());
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        binding.artistList.setLayoutManager(layoutManager2);
        binding.artistList.setAdapter(artistsAdapter);


        album.clear();
        album.add(new AlbumModel(R.drawable.music_boy, "Battle Studies", "John Mayer"));
        album.add(new AlbumModel(R.drawable.blackwaterpark, "Blackwater Park", "Opeth"));
        albumAdapter = new AlbumAdapter(album, getContext());
        binding.albumList.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.albumList.setAdapter(albumAdapter);

        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        binding.etSearch.requestFocus();
        binding.etSearch.setFocusable(true);


      //edittext in search then searchlist is shown:
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                binding.searchListView.setVisibility(View.VISIBLE);
                binding.txtSearchLibrary.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//            // On JellyBean & above, you can provide a shortcut and an explicit Locale
//            UserDictionary.Words.addWord(getContext(), "HelloWorld", 10, "Mad", Locale.getDefault());
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.CUPCAKE) {
//            UserDictionary.Words.addWord(getContext(), "HelloUpWorld", 10, UserDictionary.Words.LOCALE_TYPE_CURRENT);
//        }
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




