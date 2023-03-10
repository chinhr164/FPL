package com.zrapp.notecontent;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "GhiChu.sqlite";
    public static final int VERSION = 1;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    public void queryData(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public Cursor getData(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableNote =
                "CREATE TABLE tb_GhiChu (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "tieuDe TEXT," +
                        "noiDung TEXT," +
                        "ngayThang TEXT)";
        db.execSQL(createTableNote);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTableNote = "DROP TABLE IF EXISTS tb_GhiChu";
        db.execSQL(dropTableNote);
    }
}
