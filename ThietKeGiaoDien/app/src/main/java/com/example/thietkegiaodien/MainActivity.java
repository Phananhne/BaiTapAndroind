package com.example.thietkegiaodien;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtCMND, edtThongtinbosung;
    RadioGroup idgroup;
    CheckBox cbxds, cbxdb, cbxCoding;
    Button btnGuithongtin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ánh xạ id
        edtName = findViewById(R.id.edtName);
        edtCMND = findViewById(R.id.edtCMND);
        edtThongtinbosung = findViewById(R.id.edtThongtinbosung);
        idgroup = findViewById(R.id.idgroup);
        cbxds = findViewById(R.id.cbxds);
        cbxdb = findViewById(R.id.cbxdb);
        cbxCoding = findViewById(R.id.cbxCoding);
        btnGuithongtin = findViewById(R.id.btnGuithongtin);
        //
        btnGuithongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lấy thông tin họ tên
                String Name = edtName.getText().toString();
                if(Name.length()<3){
                    Toast.makeText(MainActivity.this,"Tên phải trên 3 ký tự",Toast.LENGTH_LONG).show();
                    edtName.requestFocus();
                    edtName.selectAll();
                }
                String CMND = edtCMND.getText().toString();
                if(CMND.length()<9){
                    Toast.makeText(MainActivity.this,"Mật khẩu trên 9 ký tự",Toast.LENGTH_LONG).show();
                    edtCMND.requestFocus();
                    edtCMND.selectAll();
                }
                //Lấy thông tin bằng cấp
                int idselected = idgroup.getCheckedRadioButtonId();//trả về id của các button được chọn trong phương thức này
                RadioButton radiogroup = findViewById(idselected);//ánh xạ id của button được chọn
                String idgroupselect = radiogroup.getText().toString();
                //lấy thông tin sở thích
                String sothich = " ";
                if(cbxds.isChecked())
                    sothich += cbxds.getText().toString() + "-";
                if(cbxdb.isChecked())
                    sothich += cbxdb.getText().toString() + "-";
                if(cbxCoding.isChecked())
                    sothich += cbxCoding.getText().toString() + "-";
                //lấy thông tin bổ sung
                String thongtin = edtThongtinbosung.getText().toString();
                String tonghop = Name + "\n" + CMND + "\n"+ idgroupselect + "\n"+sothich+"\n";
                       tonghop +="-----------------Thông tin bổ sung----------------------------"+"\n";
                       tonghop += thongtin+"\n";
                       tonghop +="--------------------------------------------------------------"+"\n";
                //Tạo Dialog và hiển thị thông tin tổng hợp
                AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
                mydialog.setTitle("Tổng hợp thông tin");
                mydialog.setMessage(tonghop);
                mydialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }

                });
                mydialog.create().show();



            }
        });
    }
}