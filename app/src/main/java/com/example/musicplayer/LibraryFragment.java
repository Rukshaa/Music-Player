package com.example.musicplayer;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.musicplayer.adapter.SongsAdapter;
import com.example.musicplayer.databinding.FragmentLibraryBinding;
import com.example.musicplayer.model.SongsModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import in.myinnos.alphabetsindexfastscrollrecycler.IndexFastScrollRecyclerView;

public class LibraryFragment extends Fragment {

    List<SongsModel> song = new ArrayList<>();
    SongsAdapter songsAdapter;

    FragmentLibraryBinding binding;
    IndexFastScrollRecyclerView mRecyclerView;

    private List<String> mDataArray;

    public LibraryFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_library, container, false);
//
//        if (getActivity() instanceof DashboardActivity) {
//            ActionBar actionBar = ((DashboardActivity) getActivity()).getSupportActionBar();
//            assert actionBar != null;
//            actionBar.hide();
//            CollapsingToolbarLayout collapsingToolbarLayout = getActivity().findViewById(R.id.collapsing_toolbar);
//            collapsingToolbarLayout.setTitle("Library");
//        }
//
        binding.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null == view) {
                    tab.setCustomView(R.layout.tab_text);
                }
                TextView textView = tab.getCustomView().findViewById(android.R.id.text1);
                textView.setTextColor(binding.tabs.getTabTextColors());
                Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.interbold);
                textView.setTypeface(typeface);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null == view) {
                    tab.setCustomView(R.layout.tab_text);
                }
                TextView textView = tab.getCustomView().findViewById(android.R.id.text1);

                Typeface typeface = ResourcesCompat.getFont(getContext(), R.font.interregular);
                textView.setTypeface(typeface);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setupViewPager(binding.viewpager);
        binding.tabs.setupWithViewPager(binding.viewpager);
        return binding.getRoot();
    }

    private void setupViewPager(ViewPager viewPager) {
        SectionPageAdapter adapter = new SectionPageAdapter(getChildFragmentManager());
        adapter.addFragment(new SongsFragment(), "Songs");
        adapter.addFragment(new AlbumsFragment(), "Albums");
        adapter.addFragment(new ArtistsFragment(), "Artists");
        adapter.addFragment(new GenresFragment(), "Genres");
        viewPager.setAdapter(adapter);

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
