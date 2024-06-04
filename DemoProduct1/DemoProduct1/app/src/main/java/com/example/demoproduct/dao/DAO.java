package com.example.demoproduct.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.demoproduct.database.DBHelper;
import com.example.demoproduct.models.Product;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class DAO {
    private DBHelper dbHelper;
    public DAO(Context context){
        dbHelper = new DBHelper(context);

    }
    public List<Product> GetAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        List<Product> listProduct = new ArrayList<>();
        String query = "SELECT * FROM product";
        Cursor c = db.rawQuery(query,null);
        while (c.moveToNext()){
            Product temp = new Product();
            temp.setId(c.getInt(0));
            temp.setName(c.getString(1));
            temp.setPrice(c.getFloat(2));
            temp.setImage(c.getString(3));
            listProduct.add(temp);

        }
        return listProduct;
    }
    public void Insert(Product p){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
            values.put("name",p.getName());
            values.put("price",p.getPrice());
            values.put("image",p.getImage());
        db.insert("product",null,values);
    }
    public void Delete(int productId){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Define the whereClause and whereArgs for the delete operation
        String whereClause = "id=?";
        String[] whereArgs = new String[]{String.valueOf(productId)};

        // Perform the delete operation
//        db.delete(DBHelper.product, whereClause, whereArgs);

        // Close the database connection when done
        db.close();
    }

}
