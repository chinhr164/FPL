package com.zrapp.notecontent;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DAO {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public DAO(Context context) {
        dbHelper = new DbHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public Cursor providerSelectAll(String[] columns, String selection, String[] selectionArgs, String orderBy) {
        Cursor c = db.query("tb_GhiChu", columns, selection, selectionArgs, null, null, orderBy);
        return c;
    }

    public ArrayList<Notes> getAll() {
        ArrayList<Notes> list = new ArrayList<>();
        Cursor c = dbHelper.getData("SELECT * FROM tb_GhiChu");
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            Notes note = new Notes();
            note.setId(c.getInt(0));
            note.setTieuDe(c.getString(1));
            note.setNoiDung(c.getString(2));
            note.setNgayThang(c.getString(3));
            list.add(note);
        }
        c.close();
        return list;
    }

    public void insert(Notes note) {
        dbHelper.queryData("INSERT INTO tb_GhiChu VALUES(null,'"
                + note.getTieuDe() + "','"
                + note.getNoiDung() + "','"
                + note.getNgayThang() + "')");
    }

    public void update(int id, Notes note) {
        dbHelper.queryData("UPDATE tb_GhiChu SET "
                + "tieuDe = '" + note.getTieuDe() + "',"
                + "noiDung = '" + note.getNoiDung() + "',"
                + "ngayThang = '" + note.getNgayThang() + "' "
                + "WHERE id = " + id);
    }

    public void delete(int id) {
        dbHelper.queryData("DELETE FROM tb_GhiChu WHERE id = '" + id + "'");
    }
}
