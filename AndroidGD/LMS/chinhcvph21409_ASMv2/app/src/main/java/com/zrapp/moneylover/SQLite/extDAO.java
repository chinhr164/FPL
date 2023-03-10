package com.zrapp.moneylover.SQLite;

import android.content.Context;
import android.database.Cursor;

import com.zrapp.moneylover.model.ExpenseType;

import java.util.ArrayList;

public class extDAO {
    Context context;
    private DbHelper dbHelper;

    public extDAO(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }


    public ArrayList<ExpenseType> getALL() {
        ArrayList<ExpenseType> list = new ArrayList<>();

        Cursor c = dbHelper.getData("SELECT * FROM LoaiChi");
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            ExpenseType ext = new ExpenseType();
            ext.setId(c.getInt(0));
            ext.setName(c.getString(1));
            list.add(ext);
        }
        c.close();
        return list;
    }

    public ArrayList<ExpenseType> getExs(int id) {
        ArrayList<ExpenseType> list = new ArrayList<>();

        Cursor c = dbHelper.getData("SELECT * FROM KhoanChi WHERE idLoaiChi = " + id);
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            ExpenseType ext = new ExpenseType();
            ext.setId(c.getInt(0));
            ext.setName(c.getString(1));
            list.add(ext);
        }
        c.close();
        return list;
    }

    public void insert(String name) {
        dbHelper.queryData("INSERT INTO LoaiChi VALUES(null,'" + name + "')");
    }

    public void update(int id, String name) {
        dbHelper.queryData("UPDATE LoaiChi SET tenLoaiChi = '" + name + "' WHERE id = " + id);
    }

    public void delete(int id) {
        dbHelper.queryData("DELETE FROM LoaiChi WHERE id = '" + id + "'");
    }
}
