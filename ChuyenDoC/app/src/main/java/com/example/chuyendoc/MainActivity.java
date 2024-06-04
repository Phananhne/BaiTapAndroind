package com.example.chuyendoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtF, edtC;
    Button btnFC, btnCF, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ
        edtF = findViewById(R.id.edtF);
        edtC = findViewById(R.id.edtC);
        btnFC = findViewById(R.id.btnFC);
        btnCF = findViewById(R.id.btnCF);
        btnClear = findViewById(R.id.btnClear);
        //
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtF.getText().toString());
                double b = a*1.8+3.2;
                edtC.setText(b +"");

            }
        });
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int c = Integer.parseInt(edtC.getText().toString());
                double d = (c-3.2)/1.8;
                edtF.setText(d+"");
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtF.setText("");
                edtC.setText("");
            }
        });

    }
}