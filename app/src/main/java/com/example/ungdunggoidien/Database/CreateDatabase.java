package com.example.ungdunggoidien.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
import androidx.core.database.sqlite.SQLiteDatabaseKt;

public class CreateDatabase extends SQLiteOpenHelper {
    public static String TB_User = "User";
    public static String TB_User_MaUser = "MaUser";
    public  static String TB_User_NameUser = "NameUser";
    public static String TB_User_Password = "Password";
    public static String TB_User_Gender = "Gender";

    public static String TB_User_Date = "Date";


    public CreateDatabase(Context context) {
        super(context,"HoaDon",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbUser  = "CREATE TABLE "+TB_User + " ( "+TB_User_MaUser + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +TB_User_NameUser + " TEXT, "+TB_User_Password + " TEXT, " + TB_User_Gender + " TEXT, " + TB_User_Date + "TEXT, )";

    db.execSQL(tbUser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public SQLiteDatabase Open(){
        return this.getWritableDatabase();

    }
}
