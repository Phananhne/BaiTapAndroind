package com.example.truyendulieugiuaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnKQ = findViewById(R.id.btnKQ);
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent
                Intent inten = new Intent(MainActivity.this, Resuit.class);
                //Lấy dữ liệu
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                //Đóng gói dữ liệu vào Bundle
                Bundle bun = new Bundle();
                //Đưa dữ liệu vào Bundle
                bun.putInt("soa",a);
                bun.putInt("sob",b);
                //Đưa Bundle vào Intent
                inten.putExtra("mybackpage",bun);

                //Khởi động
                startActivity(inten);
            }
        });
    }
}