package com.zrapp.entertainment.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "entertainment.sqlite";
    public static final int VERSION = 1;

    public DbHelper(Context context) {super(context, DB_NAME, null, VERSION);}

    public SQLiteDatabase queryData() {
        return getWritableDatabase();
    }

    public Cursor getData(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE User(" +
                "username TEXT PRIMARY KEY," +
                "password TEXT," +
                "name TEXT," + 
                "tel TEXT," + 
                "email TEXT," +
                "avatar BLOB," + 
                "cover BLOB)";
        db.execSQL(createTable);

        String createFavor ="CREATE TABLE Favor(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "author TEXT," +
                "path TEXT)";
        db.execSQL(createFavor);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTable = "DROP TABLE IF EXISTS User";
        db.execSQL(dropTable);

        String dropFavor = "DROP TABLE IF EXISTS Favora";
        db.execSQL(dropFavor);
    }
}
