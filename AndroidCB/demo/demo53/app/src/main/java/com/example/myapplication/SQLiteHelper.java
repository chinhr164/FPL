package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String SQL_PRODUCT = "CREATE TABLE PRODUCT(" +
            "id text PRIMARY KEY," +
            "name text," +
            "price real," +
            "image real);";

    public static final String SQL_SanPham = "CREATE TABLE SanPham(" +
            "id text PRIMARY KEY," +
            " name text," +
            " qty text);";


    //Tạo database
    public SQLiteHelper(Context context) {
        super(context, "QLBH.db", null, 1);//Thực thi tạo CSDL
    }

    //Tạo bảng dữ liệu
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_PRODUCT);//Lệnh tạo mới
        db.execSQL(SQL_SanPham);//Lệnh tạo mới
    }

    //Xoá bảng dữ liệu cũ và tạo mới
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PRODUCT");//Xoá bảng cũ, tạo bảng mới
        db.execSQL("DROP TABLE IF EXISTS SanPham");//Xoá bảng cũ, tạo bảng mới
    }
}
