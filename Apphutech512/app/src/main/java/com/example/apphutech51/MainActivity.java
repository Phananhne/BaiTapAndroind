package com.example.apphutech51;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.asm5_1.Adapter.NewsAdapter;
import com.example.asm5_1.model.NewsItem;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<NewsItem> listnews = new ArrayList<>();
    private NewsAdapter adapter = new NewsAdapter(listnews);
    private static final int ADD_NEWS_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rcvNew);
        FloatingActionButton fabAddNews = findViewById(R.id.fabAdd);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        fabAddNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddNewsActivity();
            }
        });

        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                openDetailActivity(listnews.get(position).getUrl());
            }
        });

        populateNewsList();
    }

    private void openAddNewsActivity() {
        Intent addNewsIntent = new Intent(MainActivity.this, AddNewsActivity.class);
        startActivityForResult(addNewsIntent, ADD_NEWS_REQUEST_CODE);
    }

    private void addNews(String title, String imageUrl, String url) {
        listnews.add(new NewsItem(title, url, imageUrl));
        adapter.notifyDataSetChanged();
    }

    private void openDetailActivity(String url) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    private void populateNewsList() {
        listnews.add(new NewsItem("Sáng tạo bảo tàng bằng tư duy hiện đại, cựu sinh viên HUTECH xuất sắc giành Giải thưởng Kiến trúc Quốc tế AMP 2023", "https://www.hutech.edu.vn/homepage/tin-tuc/tin-hutech/14614366-sang-tao-bao-tang-bang-tu-duy-hien-dai-cuu-sinh-vien-hutech-xuat-sac-gianh-giai-thuong-kien-truc-quo", "https://file1.hutech.edu.vn/file/news/1646471702714087.jpg"));
        listnews.add(new NewsItem("Ra mắt CLB Tình nguyện Cộng đồng: Mang sức trẻ lan tỏa nhiều giá trị thiết thực cho cộng đồng", "https://www.hutech.edu.vn/homepage/tin-tuc/hoat-dong-sinh-vien/14614364-ra-mat-clb-tinh-nguyen-cong-dong-mang-suc-tre-lan-toa-nhieu-gia-tri-thiet-thuc-cho-cong-dong", "https://file1.hutech.edu.vn/file/editor/homepage1/31404-img_1904.jpg"));
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_NEWS_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String title = data.getStringExtra("title");
            String imageUrl = data.getStringExtra("imageUrl");
            String url = data.getStringExtra("url");

            addNews(title, imageUrl, url);
            Toast.makeText(this, "News added successfully", Toast.LENGTH_SHORT).show();
        }
    }
}
