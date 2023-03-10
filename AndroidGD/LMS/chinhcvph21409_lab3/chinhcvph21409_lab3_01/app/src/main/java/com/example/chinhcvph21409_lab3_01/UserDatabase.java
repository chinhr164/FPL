package com.example.chinhcvph21409_lab3_01;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class UserDatabase extends SQLiteOpenHelper {


    public UserDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void InsertData(String id, String name, byte[] img) {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO User VALUES(?,?,?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.bindString(1, id);
        statement.bindString(2, name);
        statement.bindBlob(3, img);
        statement.executeInsert();
    }

    public Cursor GetData(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
