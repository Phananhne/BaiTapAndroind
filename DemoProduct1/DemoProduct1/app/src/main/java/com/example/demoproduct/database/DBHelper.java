package com.example.demoproduct.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper (Context context) {
        super(context,"QLSP",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = String .format("Create table %s (" +
                        "%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "$S TEXT,"+
                        "%s REAL,"+
                        "%s TEXT)",
                "Product","id","name","price","image");

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion!= newVersion){
            String query = "DROP TABLE Product";
            db.execSQL(query);
            onCreate(db);
        }
    }
}
