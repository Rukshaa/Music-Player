package com.example.musicplayer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.SectionIndexer;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.MainActivity;
import com.example.musicplayer.R;
import com.example.musicplayer.databinding.SongsLayoutBinding;
import com.example.musicplayer.model.SongsModel;

import java.util.ArrayList;
import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> implements SectionIndexer {
    private List<SongsModel> song;
    private Context context;

    private ArrayList<Integer> mSectionPositions;
    private String mSections = "ABCDEFGHIJKLMNOPQRSTUVWXYZ#";
    SongsLayoutBinding binding;

    public SongsAdapter(List<SongsModel> song, Context context) {
        this.song= song;
        this.context = context;
    }
    @Override
    public Object[] getSections() {

        ArrayList<String> alphabetFull = new ArrayList<>();

        mSectionPositions = new ArrayList<>();
        List<String> sections = new ArrayList<>(27);

        for (int i = 0, size = song.size(); i < size; i++) {
            String section = String.valueOf(song.get(i).getSongTitle().charAt(0)).toUpperCase();
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
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.songs_layout,parent,false);
        return new SongsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        SongsModel songs= song.get(position);
        holder.binding.americaImg.setImageResource(songs.getSongImage());
        holder.binding.titleText.setText(songs.getSongTitle());
        holder.binding.subText.setText(songs.getSubTitle());

        holder.binding.recycle.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }
    @Override
    public int getItemCount() {
        return song.size();
    }

    public class SongsViewHolder extends RecyclerView.ViewHolder {

        SongsLayoutBinding binding;
        public  SongsViewHolder(@NonNull SongsLayoutBinding b) {
            super(b.getRoot());
            binding = b;

        }
    }
}
