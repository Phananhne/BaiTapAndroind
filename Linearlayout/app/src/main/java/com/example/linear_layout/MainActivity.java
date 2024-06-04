package com.example.linear_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtdocthan, txtdcc, txtLGBT;
    Button btndt, btndcc, btnlgbt;
    int countdt = 0;
    int countdcc = 0;
    int countlgnbt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtdocthan = findViewById(R.id.txtdocthan);
        txtdcc = findViewById(R.id.txtdcc);
        txtLGBT = findViewById(R.id.txtLGBT);
        btndt = findViewById(R.id.btndt);
        btndcc = findViewById(R.id.btndcc);
        btnlgbt = findViewById(R.id.btnlgbt);
        btndt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countdt = countdt + 1;
                txtdocthan.setText("Độc thân "+ countdt);
            }
        });
        btndcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countdcc = countdcc + 1;
                txtdcc.setText("Đã có chủ: "+ countdcc);
            }
        });
        btnlgbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countlgnbt = countlgnbt + 1;
                txtLGBT.setText("LGBT: "+countlgnbt);
            }
        });


    }
}