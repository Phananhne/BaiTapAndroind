package com.example.api;

import static com.example.api.R.id.btnAdd;
import static com.example.api.R.id.rcvProduct;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api.adapter.ProductAdapter;
import com.example.api.model.Product;
import com.example.api.service.IProductService;
import com.example.api.service.RetrofitInstance;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.chromium.base.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    List<Product> listProduct = new ArrayList<>();
    ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetListProductAPI();
        adapter = new ProductAdapter(listProduct);
        RecyclerView rcvProduct = findViewById(R.id.rcvProduct);
        rcvProduct.setAdapter(adapter);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);
        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void GetListProductAPI() {
        Call<List<Product>> call = RetrofitInstance.getRetrofitInstance().create(IProductService.class).getProducts();
        call.enqueue(new Callback<List<Product>>() {


            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if(response.isSuccessful()){
                    List<Product> listProduct = response.body();
                    Toast.makeText(MainActivity.this, "Tổng số: "+ listProduct.size(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Error: ", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Log.e("Network Request", "Error", t);
                Toast.makeText(MainActivity.this, "Error: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

}