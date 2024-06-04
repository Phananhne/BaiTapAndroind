package com.example.app_karaoke;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.app_karaoke.Adapter.SongAdapter;
import com.example.app_karaoke.Models.Song;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Song> songList;
    SongAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songList = Song.getSongList();
        songAdapter = new SongAdapter(songList);
        RecyclerView rcSong = findViewById(R.id.rcSong);
        rcSong.setAdapter(songAdapter);
        rcSong.setLayoutManager(new LinearLayoutManager(this));
        Button btnAddSong = findViewById(R.id.btnAddSong);
        btnAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Mở dialog thêm bài hát
                add_song_dialog_fragment dialog = new add_song_dialog_fragment(songList, songAdapter);
                dialog.show(getSupportFragmentManager(), "");

            }
        });
        RecyclerView recyclerView = findViewById(R.id.rcSong);

        SongAdapter adapter = new SongAdapter(songList);

// Set adapter cho RecyclerView
        recyclerView.setAdapter(adapter);

// Khởi tạo ItemTouchHelper
        ItemTouchHelper helper = new ItemTouchHelper(
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        // Lấy vị trí của item swiped
                        int position = viewHolder.getAdapterPosition();

                        // Xóa item khỏi danh sách
                        songList.remove(position);

                        // Thông báo dữ liệu thay đổi để cập nhật UI
                        adapter.notifyItemRemoved(position);
                    }

                });

// Áp dụng ItemTouchHelper cho RecyclerView
        helper.attachToRecyclerView(recyclerView);
    }
}