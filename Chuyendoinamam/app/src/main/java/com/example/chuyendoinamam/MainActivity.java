package com.example.chuyendoinamam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    EditText edtDL, edtAL;
    Button btnChuyenDoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        edtDL=findViewById(R.id.edtDL);
        edtAL = findViewById(R.id.edtAL);
        btnChuyenDoi=findViewById(R.id.btnChuyendoi);
        //
        btnChuyenDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtDL.getText().toString());
                String can = "", chi = "";
                switch (a % 10) {
                    case 0:
                        can = "canh";
                        break;
                    case 1:
                        can = "Tân";
                        break;
                    case 2:
                        can = "Nhâm";
                        break;
                    case 3:
                        can = "Quý";
                        break;
                    case 4:
                        can = "Giáp";
                        break;
                    case 5:
                        can = "Ất";
                        break;
                    case 6:
                        can = "Bính";
                        break;
                    case 7:
                        can = "Đinh";
                        break;
                    case 8:
                        can = "Mậu";
                        break;
                    case 9:
                        can = "Kỷ";
                        break;

                }
                switch (a % 12) {
                    case 0:
                        chi = "Thân";
                        break;
                    case 1:
                        chi = "Dậu";
                        break;
                    case 2:
                        chi = "Tuất";
                        break;
                    case 3:
                        chi = "Hợi";
                        break;
                    case 4:
                        chi = "Tý";
                        break;
                    case 5:
                        chi = "Sửu";
                        break;
                    case 6:
                        chi = "Dần";
                        break;
                    case 7:
                        chi = "Mão";
                        break;
                    case 8:
                        chi = "Thìn";
                        break;
                    case 9:
                        chi = "Tỵ";
                        break;
                    case 10:
                        chi = "Ngọ";
                        break;
                    case 11:
                        chi = "Mùi";
                        break;
                }
                String b = can + " " + chi;
                edtAL.setText(b);
            }
        });
    }
}