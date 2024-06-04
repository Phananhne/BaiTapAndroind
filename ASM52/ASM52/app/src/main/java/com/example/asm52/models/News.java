package com.example.asm52.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;
public class News {


    private String title;
    private String url;
    private String imageUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public News() {
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public News(String title, String url, String imageUrl) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public News(String title, String url, String imageUrl, Bitmap bitmap) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
        this.imageBitmap = bitmap;
    }


    public static List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        News newsDefault1 = new News(
                "One Piece 1102 Spoiler: Điểm dừng cuối cùng trong cuộc đời của Kuma",
                "https://game4v.com/one-piece-1102-spoiler-diem-dung-cuoi-cung-trong-cuoc-doi-cua-kuma-992729.g4v",
                "https://ecdn.game4v.com/g4v-content/uploads/2023/12/19124613/Op-1102-1-game4v-1702964772-17.jpg");

        News newsDefault2 = new News(
                "Tổng hợp những tin tức đáng chú ý nhất đã được công bố trong sự kiện Jump Festa 2024",
                "https://game4v.com/tong-hop-nhung-tin-tuc-dang-chu-y-nhat-da-duoc-cong-bo-trong-su-kien-jump-festa-2024-992554.g4v",
                "https://ecdn.game4v.com/g4v-content/uploads/2023/12/18104128/Jump-1-game4v-1702870886-39.jpg");
        News newsDefault3 = new News(
                "Tác giả Jujutsu Kaisen xác nhận rằng bộ truyện sẽ kết thúc trong năm 2024",
                "https://game4v.com/tac-gia-jujutsu-kaisen-xac-nhan-rang-bo-truyen-se-ket-thuc-trong-nam-2024-992693.g4v",
                "https://ecdn.game4v.com/g4v-content/uploads/2023/12/19080611/Jujutsu-Jump-1-game4v-1702947970-7.jpg");
        News newsDefault4 = new News(
                "Không ngoài dự đoán, anime My Hero Academia ss7 sẽ lên sóng trong năm 2024",
                "https://game4v.com/khong-ngoai-du-doan-anime-my-hero-academia-ss7-se-len-song-trong-nam-2024-992417.g4v",
                "https://ecdn.game4v.com/g4v-content/uploads/2023/12/17102038/My-Hero-Academia-ss7-01-game4v-1702783236-70.png");
        News newsDefault5 = new News(
                "Naruto là anime được tìm kiếm nhiều nhất trên Google trong suốt 25 năm qua",
                "https://game4v.com/naruto-la-anime-duoc-tim-kiem-nhieu-nhat-tren-google-trong-suot-25-nam-qua-992290.g4v",
                "https://ecdn.game4v.com/g4v-content/uploads/2023/12/16102007/Naruto-Google-1-game4v-1702696805-40.png");
        newsList.add(newsDefault1);
        newsList.add(newsDefault2);
        newsList.add(newsDefault3);
        newsList.add(newsDefault4);
        newsList.add(newsDefault5);
        return newsList;
    }

    private Bitmap imageBitmap;

    public void setImageBitmap(Bitmap bitmap) {
        this.imageBitmap = bitmap;
    }
}


