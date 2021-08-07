package com.example.musicplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;
import com.example.musicplayer.databinding.SearchLayoutBinding;
import com.example.musicplayer.model.SearchModel;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    private List<SearchModel> search;
    private Context context;

    SearchLayoutBinding binding;
    public SearchAdapter(List<SearchModel> search, Context context) {
        this.search= search;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.search_layout,parent,false);
        return new SearchViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        SearchModel searchs= search.get(position);
        holder.binding.imgamerica.setImageResource(searchs.getSongImg());
        holder.binding.txtTitle.setText(searchs.getTitleSong());
        holder.binding.txtSub.setText(searchs.getTitleSub());

    }
    @Override
    public int getItemCount() {
        return search.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

       SearchLayoutBinding binding;
        public  SearchViewHolder(@NonNull SearchLayoutBinding b) {
            super(b.getRoot());
            binding = b;

        }
    }
}
