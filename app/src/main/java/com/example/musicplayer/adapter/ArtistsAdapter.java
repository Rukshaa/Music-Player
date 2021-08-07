package com.example.musicplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SectionIndexer;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.databinding.ArtistsLayoutBinding;
import com.example.musicplayer.model.ArtistsModel;

import java.util.ArrayList;
import java.util.List;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder> implements SectionIndexer {
    private List<ArtistsModel> artist;
    private Context context;

    private ArrayList<Integer> mSectionPositions;
    private String mSections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
   ArtistsLayoutBinding binding;

    public ArtistsAdapter(List<ArtistsModel> artist, Context context) {
        this.artist= artist;
        this.context = context;
    }
    @Override
    public Object[] getSections() {

        ArrayList<String> alphabetFull = new ArrayList<>();

        mSectionPositions = new ArrayList<>();
        List<String> sections = new ArrayList<>(27);

        for (int i = 0, size = artist.size(); i < size; i++) {
            String section = String.valueOf(artist.get(i).getSongTitles().charAt(0)).toUpperCase();
            if (!sections.contains(section)) {
                sections.add(section);
                mSectionPositions.add(i);
            }
        }

        for (int i = 0; i < mSections.length(); i++) {
            alphabetFull.add(String.valueOf(mSections.charAt(i)));
        }
        return alphabetFull.toArray(new String[0]);
    }



    @Override
    public int getPositionForSection(int sectionIndex) {
        return mSectionPositions.get(sectionIndex);
    }

    @Override
    public int getSectionForPosition(int i) {
        return 0;
    }

    @NonNull
    @Override
    public ArtistsAdapter.ArtistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.artists_layout,parent,false);
        return new ArtistsAdapter.ArtistsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ArtistsViewHolder holder, int position) {
        ArtistsModel artists= artist.get(position);
        holder.binding.circleImg.setImageResource(artists.getSongImages());
        holder.binding.titleTexts.setText(artists.getSongTitles());
        holder.binding.subTexts.setText(artists.getSubTitles());

    }
    @Override
    public int getItemCount() {
        return artist.size();
    }

    public class ArtistsViewHolder extends RecyclerView.ViewHolder {

        ArtistsLayoutBinding binding;
        public  ArtistsViewHolder(@NonNull ArtistsLayoutBinding b) {
            super(b.getRoot());
            binding = b;

        }
    }
}


