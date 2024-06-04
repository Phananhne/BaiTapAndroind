package com.example.app_karaoke.Adapter;


import com.example.app_karaoke.Models.Song;
import com.example.app_karaoke.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter  extends RecyclerView.Adapter<SongAdapter.ViewHolder>{

    List<Song> songList;
    public SongAdapter(List<Song> songList) {
        this.songList = songList;
    }
    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View songView = inflater.inflate(R.layout.item_song, parent, false);
        return new ViewHolder(songView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.tvSongId.setText(song.getId());
        holder.tvSongName.setText(song.getName());
        holder.tvSongDescription.setText(song.getDescription());
        holder.tvSongAuthor.setText(song.getAuthor());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvSongId;
        TextView tvSongName;
        TextView tvSongDescription;
        TextView tvSongAuthor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSongId = (TextView) itemView.findViewById(R.id.tvSongId);
            tvSongName = (TextView) itemView.findViewById(R.id.tvSongName);
            tvSongDescription = (TextView) itemView.findViewById(R.id.tvSongDescription);
            tvSongAuthor = (TextView) itemView.findViewById(R.id.tvSongAuthor);
        }
    }

}
