package com.example.listproduct;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_NAME = "productList.db";
    public static final int VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, TABLE_NAME, null, VERSION);
    }

    public void QuerryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor getData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}