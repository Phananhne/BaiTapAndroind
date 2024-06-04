package com.example.ungdunggoidien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.example.ungdunggoidien.Database.CreateDatabase;

public class DangKy extends AppCompatActivity {

    EditText edtName, edtPass, edtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* CreateDatabase createDatabase = new CreateDatabase(this);*/

    }
}