package com.example.sqlite.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabase extends SQLiteOpenHelper {
    //"CREATE TABLE students( ma VACHAR(10) ,ten NVACHAR(30) )"
    public static final String TABLE_NAME = "student.db";
    public static final int VERSION = 1;


    public MyDatabase(Context context) {
        //tạo database
        super(context, TABLE_NAME, null, VERSION);

    }

    //Truy vấn không trả về dũ liệu : CREATE , INSERT, UPDATE,DELETE
    public void QuerryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //TRUY VẤN TRẢ VỀ DŨ LIỆU : select
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        //đây là hàm chạy khi chưa có bảng trong database
//        SQLiteDatabase database = getWritableDatabase();
//        database.execSQL("CREATE TABLE IF NOT EXISTS Sinhvien(ID INTEGER PRIMARY KEY AUTOINCREMENT," +
//                "MA VACHAR(10) ,NAME VACHAR(20))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //đây là hàm chạy khi thay đổi version

    }
}
