package com.example.musicplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.databinding.AlbumsLayoutBinding;
import com.example.musicplayer.model.AlbumModel;
import com.example.musicplayer.utils.RoundedTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AlbumAdapter  extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    private List<AlbumModel> album;
    private Context context;

    AlbumsLayoutBinding binding;
    public AlbumAdapter(List<AlbumModel> album, Context context) {
        this.album= album;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context),R.layout.albums_layout,parent,false);
//        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams((int) (parent.getMeasuredWidth()*0.99), ViewGroup.LayoutParams.WRAP_CONTENT);
//        binding.albumHolder.setLayoutParams(params);

        return new AlbumViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
       AlbumModel albums = album.get(position);
        Picasso.with(context)
                .load(albums.getImages())
                .transform(new RoundedTransformation(30, 0))
                .into(binding.boy);
        holder.binding.titleText.setText(albums.getTitleText());
        holder.binding.text.setText(albums.getContentText());


    }

    @Override
    public int getItemCount()
    {
        return album.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {
        AlbumsLayoutBinding binding;
        public  AlbumViewHolder(@NonNull AlbumsLayoutBinding b) {
            super(b.getRoot());
            binding = b;

        }
    }
}


