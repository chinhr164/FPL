package com.zrapp.moneylover.SQLite;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.zrapp.moneylover.model.ExpenseType;
import com.zrapp.moneylover.model.Expenses;

import java.util.ArrayList;

public class exsDAO {
    Context context;
    private DbHelper dbHelper;

    public exsDAO(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Expenses> getAll() {
        ArrayList<Expenses> list = new ArrayList<>();
        Cursor c = dbHelper.getData("SELECT * FROM KhoanChi");
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            Expenses exs = new Expenses();
            exs.setId(c.getInt(0));
            exs.setId_ExT(c.getInt(1));
            exs.setName(c.getString(2));
            exs.setDate(c.getString(3));
            exs.setPrice(c.getInt(4));
            exs.setUser(c.getString(5));
            list.add(exs);
        }
        c.close();
        return list;
    }

    public ArrayList<String> getExt() {
        ArrayList<String> list = new ArrayList<>();
        Cursor c = dbHelper.getData("SELECT * FROM LoaiChi");
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            ExpenseType ext = new ExpenseType();
            ext.setName(c.getString(1));
            list.add(ext.getName());
        }
        c.close();
        return list;
    }

    public void insert(Expenses exs) {
        dbHelper.queryData("INSERT INTO KhoanChi VALUES(null,'"
                + exs.getId_ExT() + "','"
                + exs.getName() + "','"
                + exs.getDate() + "','"
                + exs.getPrice() + "','"
                + exs.getUser() + "')");
    }

    public void upgrade(Expenses exs) {
        dbHelper.queryData("INSERT INTO KhoanChi VALUES('"
                + exs.getId() + "','"
                + exs.getId_ExT() + "','"
                + exs.getName() + "','"
                + exs.getDate() + "','"
                + exs.getPrice() + "','"
                + exs.getUser() + "')");
    }

    public void update(int id, Expenses exs) {
        dbHelper.queryData("UPDATE KhoanChi SET "
                + "idLoaiChi = '" + exs.getId_ExT() + "',"
                + "tenKhoanChi = '" + exs.getName() + "',"
                + "ngayChi = '" + exs.getDate() + "',"
                + "soTien = '" + exs.getPrice() + "',"
                + "nguoiChi = '" + exs.getUser() + "' "
                + "WHERE id = " + id);
    }

    public void delete(int id) {
        dbHelper.queryData("DELETE FROM KhoanChi WHERE id = '" + id + "'");
    }

    public String getSumQty(String from, String to) {
        Cursor c = dbHelper.getData("SELECT COUNT (*) FROM KhoanChi WHERE ngayChi >= '" + from + "' AND ngayChi <= '" + to + "'");
        c.moveToFirst();
        return c.getString(0);
    }

    public long getSumPrice(String from, String to) {
        Cursor c = dbHelper.getData("SELECT SUM (soTien) FROM KhoanChi WHERE ngayChi >= '" + from + "' AND ngayChi <= '" + to + "'");
        c.moveToFirst();
        return c.getLong(0);
    }

}
