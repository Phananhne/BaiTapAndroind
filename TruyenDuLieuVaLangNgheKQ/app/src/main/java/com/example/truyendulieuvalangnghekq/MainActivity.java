package com.example.truyendulieuvalangnghekq;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtData, edtKQ;
    Button btnKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtData = findViewById(R.id.edtData);
        edtKQ = findViewById(R.id.edtKQ);
        btnKQ = findViewById(R.id.btnKQ);
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai báo Intent
                Intent intent = new Intent(MainActivity.this, TraKQ.class);
                int a = Integer.parseInt(edtData.getText().toString());
                //Đưa dữ liệu vào trong Intent
                intent.putExtra("soa",a);
                startActivityForResult(intent,99);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33){
            int kq = data.getIntExtra("kq",0);
            edtKQ.setText("Giá trị gốc là: "+kq);
        }
        if(requestCode==99 && resultCode==34){
            int kq = data.getIntExtra("kq",0);
            edtKQ.setText("Giá trị bình phương là: "+kq);
        }
    }
}