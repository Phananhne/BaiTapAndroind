package com.example.truyendulieugiuaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resuit extends AppCompatActivity {

    TextView txtvKQ;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resuit);
        txtvKQ = findViewById(R.id.txtvKQ);
        btnBack = findViewById(R.id.btnBack);
        //Nhận Intent
        Intent intt = getIntent();
        //Lấy bundle khỏi Intent
        Bundle mybundle = intt.getBundleExtra("mybackpage");
        //Lấy dữ liệu khỏi bundle
        int a = mybundle.getInt("soa");
        int b = mybundle.getInt("sob");
        //Tiến hành giải PT và KQ
        String nghiem = " ";
        if(a == 0 && b == 0) {
            nghiem = "PT vô số nghiệm";
        }
        else if(a>0 && b==0) {
            nghiem = "vô nghiệm";
        }
        else if(a>0 && b > 0) {
            nghiem = "nghiệm = " + (-b) / a;
        }
        else {
            nghiem = "Nhập lại số, không đúng";
        }
        txtvKQ.setText(nghiem);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}