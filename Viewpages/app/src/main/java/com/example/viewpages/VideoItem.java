package com.example.viewpages;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class VideoItem {
    public String Url;
    public String Title;
    public String Description;
    public VideoItem(String url, String title, String description) {
        Url = url;
        Title = title;
        Description = description;
    }
    public static List<VideoItem> GetList(Context context){
        List<VideoItem> list = new ArrayList<VideoItem>();

        VideoItem itemvideo1 = new VideoItem("video1.mp4","From RAW folder","test Video 0");
        VideoItem itemvideo2 = new VideoItem("video2.mp4","From RAW2 folder","test Video 1");

        itemvideo1.Url = "android.resource://" + context.getPackageName() + "/" + R.raw.video1;
        itemvideo2.Url = "android.resource://" + context.getPackageName() + "/" + R.raw.video2;

        list.add(itemvideo1);
        list.add(itemvideo2);

        list.add(new VideoItem("https://www.tiktok.com/@tiembanhduyanh.official/video/7281603974082399496?is_from_webapp=1&sender_device=pc","Bake","Test Video 3"));
        return list;
    }
}

