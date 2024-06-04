package com.example.asm52.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.asm52.MainActivity;
import com.example.asm52.R;
import com.example.asm52.models.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
    List<News> newsList;

    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    public NewsAdapter(List<News> newsList, MainActivity.OnItemClickListener onItemClickListener) {
    }
    private OnItemClickListener listener;

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater =LayoutInflater.from(context);
        View newsView = inflater.inflate(R.layout.item_news, parent, false);
        return new ViewHolder(newsView);
    }


    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.tvTitle.setText(news.getTitle());
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round);
        if (news.getImageUrl() != null) {
            Glide.with(holder.imgImage)
                    .load(news.getImageUrl())
                    .into(holder.imgImage);
        }
        else {
            holder.imgImage.setImageBitmap(news.getImageBitmap());

        }

    }


    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(News news);
    }

    public NewsAdapter(List<News> list, OnItemClickListener listener) {
        this.newsList = list;
        this.listener = listener;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imgImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            imgImage = itemView.findViewById(R.id.imgNews);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    listener.onItemClick(newsList.get(position));
                }
            });
        }

    }
}
