package com.example.sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.adapter.ProductAdapter;
import com.example.sqlite.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//    RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //insert product

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product( "test", 999, "https://file1.hutech.edu.vn/file/news/9762551702614315.jpg"));

        ProductAdapter adapter = new ProductAdapter(listProduct);
        RecyclerView rcvProduct = findViewById(R.id.rcvProduct);
        rcvProduct.setAdapter(adapter);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);

        //Animators
        //ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeItem(adapter, this));
        //itemTouchHelper.attachToRecyclerView(rcvProduct);

        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the custom dialog layout
                View viewDialog = getLayoutInflater().inflate(R.layout.dialog_product, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setView(viewDialog);
                AlertDialog alert = builder.create();
                alert.show();
                //tiếp tục viết sự kiện trong viewDialog
                EditText txtName = viewDialog.findViewById(R.id.edtName);
                EditText txtImage = viewDialog.findViewById(R.id.edtImage);
                EditText txtprice = viewDialog.findViewById(R.id.edtPrice);
                //sụ kien Save
                viewDialog.findViewById(R.id.btnDialogSaveProduct).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Product p = new Product( txtName.getText().toString(), Float.parseFloat(txtprice.getText().toString()), txtImage.getText().toString());
                        listProduct.add(p); //thêm vào
                        adapter.notifyItemInserted(listProduct.size()-1);
                        //thong bao thành công
                        Toast.makeText(viewDialog.getContext(), "thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        alert.dismiss(); //thoát khỏi dialog
                    }
                });
            }
        });

    }


}