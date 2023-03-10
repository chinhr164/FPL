package com.example.sqlitedemo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ZrDatabase extends SQLiteOpenHelper {
    private static final String nameDB = "student.db";
    private static final int vs = 1;

    public ZrDatabase(Context context) {
        super(context, nameDB, null, vs);//Hàm tạo db
    }

    //Truy vấn không trả về dữ liệu: Create, insert, update, delete
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    //Truy vấn trả về dữ liệu: select
    public Cursor getData (String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Hàm chạy khi chưa có bảng trong database\


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Hàm chạy khi thay đổi Vsion
        Log.i("onUpgrade","onUpgrade");
    }
}
