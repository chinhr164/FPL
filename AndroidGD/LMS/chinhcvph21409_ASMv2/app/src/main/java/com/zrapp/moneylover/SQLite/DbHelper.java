package com.zrapp.moneylover.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "QuanLy.sqlite";
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
        String createTableInT =
                "CREATE TABLE LoaiThu (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "username TEXT)";
        db.execSQL(createTableInT);

        String createTableInS =
                "CREATE TABLE KhoanThu(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "idLoaiThu INTEGER REFERENCES LoaiThu(id)," +
                        "tenKhoanThu TEXT," +
                        "ngayThu TEXT," +
                        "soTien INTEGER," +
                        "nguoiThu TEXT)";
        db.execSQL(createTableInS);

        String createTableExT =
                "CREATE TABLE LoaiChi (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "tenLoaiChi TEXT)";
        db.execSQL(createTableExT);

        String createTableExS =
                "CREATE TABLE KhoanChi(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "idLoaiChi INTEGER REFERENCES LoaiChi(id)," +
                        "tenKhoanChi TEXT," +
                        "ngayChi TEXT," +
                        "soTien INTEGER," +
                        "nguoiChi TEXT)";
        db.execSQL(createTableExS);

        String createTableAccount =
                "CREATE TABLE TaiKhoan(" +
                        "username TEXT PRIMARY KEY," +
                        "password TEXT," +
                        "avatar BLOB)";
        db.execSQL(createTableAccount);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String dropTableInT = "DROP TABLE IF EXISTS LoaiThu";
        db.execSQL(dropTableInT);

        String dropTableInS = "DROP TABLE IF EXISTS KhoanThu";
        db.execSQL(dropTableInS);

        String dropTableExT = "DROP TABLE IF EXISTS LoaiChi";
        db.execSQL(dropTableExT);

        String dropTableExS = "DROP TABLE IF EXISTS KhoanChi";
        db.execSQL(dropTableExS);

        String dropTableAccount = "DROP TABLE IF EXISTS TaiKhoan";
        db.execSQL(dropTableAccount);

        onCreate(db);
    }
}
