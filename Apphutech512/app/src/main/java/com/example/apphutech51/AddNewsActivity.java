package com.example.apphutech51;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewsActivity extends AppCompatActivity {
    private EditText txtTitle, txtImgUrl, txtUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);

        txtTitle = findViewById(R.id.txtTitle);
        txtImgUrl = findViewById(R.id.txtImgUrl);
        txtUrl = findViewById(R.id.txtUrl);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnBack = findViewById(R.id.btnBack);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNews();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void saveNews() {
        String title = txtTitle.getText().toString();
        String imgUrl = txtImgUrl.getText().toString();
        String url = txtUrl.getText().toString();

        Intent newsIntent = new Intent();
        newsIntent.putExtra("title", title);
        newsIntent.putExtra("imageUrl", imgUrl);
        newsIntent.putExtra("url", url);
        setResult(RESULT_OK, newsIntent);

        finish();
    }
}
