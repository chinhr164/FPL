package com.zrapp.moneylover.SQLite;

import android.content.Context;
import android.database.Cursor;

import com.zrapp.moneylover.model.ExpenseType;
import com.zrapp.moneylover.model.Expenses;
import com.zrapp.moneylover.model.IncomeType;
import com.zrapp.moneylover.model.Incomes;

import java.util.ArrayList;

public class insDAO {
    Context context;
    private DbHelper dbHelper;

    public insDAO(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Incomes> getAll() {
        ArrayList<Incomes> list = new ArrayList<>();
        Cursor c = dbHelper.getData("SELECT * FROM KhoanThu");
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            Incomes ins = new Incomes();
            ins.setId(c.getInt(0));
            ins.setId_InT(c.getInt(1));
            ins.setName(c.getString(2));
            ins.setDate(c.getString(3));
            ins.setPrice(c.getInt(4));
            ins.setUser(c.getString(5));
            list.add(ins);
        }
        c.close();
        return list;
    }

    public ArrayList<String> getInt() {
        ArrayList<String> list = new ArrayList<>();
        Cursor c = dbHelper.getData("SELECT * FROM LoaiThu");
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            IncomeType inT = new IncomeType();
            inT.setName(c.getString(1));
            list.add(inT.getName());
        }
        c.close();
        return list;
    }

    public void insert(Incomes ins) {
        dbHelper.queryData("INSERT INTO KhoanThu VALUES(null,'"
                + ins.getId_InT() + "','"
                + ins.getName() + "','"
                + ins.getDate() + "','"
                + ins.getPrice() + "','"
                + ins.getUser() + "')");
    }

    public void upgrade(Incomes ins) {
        dbHelper.queryData("INSERT INTO KhoanThu VALUES('"
                + ins.getId() + "','"
                + ins.getId_InT() + "','"
                + ins.getName() + "','"
                + ins.getDate() + "','"
                + ins.getPrice() + "','"
                + ins.getUser() + "')");
    }

    public void update(int id, Incomes ins) {
        dbHelper.queryData("UPDATE KhoanThu SET "
                + "idLoaiThu = '" + ins.getId_InT() + "',"
                + "tenKhoanThu = '" + ins.getName() + "',"
                + "ngayThu = '" + ins.getDate() + "',"
                + "soTien = '" + ins.getPrice() + "',"
                + "nguoiThu = '" + ins.getUser() + "' "
                + "WHERE id = " + id);
    }

    public void delete(int id) {
        dbHelper.queryData("DELETE FROM KhoanThu WHERE id = '" + id + "'");
    }

    public String getSumQty(String from, String to) {
        Cursor c = dbHelper.getData("SELECT COUNT (*) FROM KhoanThu WHERE ngayThu >= '" + from + "' AND ngayThu <= '" + to + "'");
        c.moveToFirst();
        return c.getString(0);
    }

    public long getSumPrice(String from, String to) {
        Cursor c = dbHelper.getData("SELECT SUM (soTien) FROM KhoanThu WHERE ngayThu >= '" + from + "' AND ngayThu <= '" + to + "'");
        c.moveToFirst();
        return c.getLong(0);
    }
}
