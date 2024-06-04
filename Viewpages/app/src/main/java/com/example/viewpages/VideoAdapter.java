package com.example.viewpages;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {
    List<VideoItem> listVideos;
    public VideoAdapter(List<VideoItem> list){
        this.listVideos = list;
    }

    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoViewHolder holder, int position) {
        VideoItem item = listVideos.get(position);
        holder.txtVideoTitle.setText(item.Title);
        holder.txtVideoDescription.setText(item.Description);
        holder.videoView.setVideoPath(item.Url);
        holder.videoView.start();
        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                holder.showProgressBtn.setVisibility(ProgressBar.INVISIBLE);
                holder.videoView.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listVideos.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        VideoView videoView;
        TextView txtVideoTitle, txtVideoDescription;
        ProgressBar showProgressBtn;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            txtVideoTitle = itemView.findViewById(R.id.textVideoTitle);
            txtVideoDescription = itemView.findViewById(R.id.textVideoDescription);
            showProgressBtn = itemView.findViewById(R.id.progressBar3);
            videoView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(videoView.isPlaying())
                        videoView.pause();
                    else
                        videoView.start();

                }
            });
            //create an object of media controller
            MediaController mediaController = new MediaController(itemView.getContext());
            videoView.setMediaController(mediaController);

            // Start video here
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    showProgressBtn.setVisibility(ProgressBar.INVISIBLE);
                    videoView.start();
                }
            });
        }
    }
}
