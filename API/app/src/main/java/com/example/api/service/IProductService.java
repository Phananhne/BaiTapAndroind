package com.example.api.service;

import com.example.api.model.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IProductService {
    @GET("api/products")
    Call<List<Product>> getProducts();
}