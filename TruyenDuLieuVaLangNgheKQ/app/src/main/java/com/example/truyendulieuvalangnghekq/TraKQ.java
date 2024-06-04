package com.example.truyendulieuvalangnghekq;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TraKQ extends AppCompatActivity {

    EditText edtDL;
    Button btnGuigoc,btnBinhphuong;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tra_kq);
        //Ánh xạ ID
        edtDL = findViewById(R.id.edtDL);
        btnGuigoc = findViewById(R.id.btnGuigoc);
        btnBinhphuong = findViewById(R.id.btnBinhphuong);
        //Nhận Intent
        intent = getIntent();
        //Lấy dữ liệu khỏi Intent
        int a = intent.getIntExtra("soa",0);
        edtDL.setText(a+"");
        btnGuigoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("kq",a);
                setResult(33,intent);
                finish();
            }
        });
        btnBinhphuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("kq",a*a);
                setResult(34,intent);
                finish();
            }
        });
    }


}