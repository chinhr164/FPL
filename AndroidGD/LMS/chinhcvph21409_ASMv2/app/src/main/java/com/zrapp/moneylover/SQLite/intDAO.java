package com.zrapp.moneylover.SQLite;

import android.content.Context;
import android.database.Cursor;

import com.zrapp.moneylover.model.ExpenseType;
import com.zrapp.moneylover.model.IncomeType;

import java.util.ArrayList;

public class intDAO {
    Context context;
    private DbHelper dbHelper;

    public intDAO(Context context) {
        this.context = context;
        dbHelper = new DbHelper(context);
    }


    public ArrayList<IncomeType> getALL() {
        ArrayList<IncomeType> list = new ArrayList<>();

        Cursor c = dbHelper.getData("SELECT * FROM LoaiThu");
        c.moveToPosition(-1);
        while (c.moveToNext()) {
            IncomeType inT = new IncomeType();
            inT.setId(c.getInt(0));
            inT.setName(c.getString(1));
            list.add(new IncomeType(inT.getId(),inT.getName()));
        }
        c.close();
        return list;
    }


    public ArrayList<IncomeType> getIns(int id) {
        ArrayList<IncomeType> list = new ArrayList<>();

        Cursor c = dbHelper.getData("SELECT * FROM KhoanThu WHERE idLoaiThu = " + id);

        c.moveToPosition(-1);
        while (c.moveToNext()) {
            IncomeType inT = new IncomeType();
            inT.setId(c.getInt(0));
            inT.setName(c.getString(1));
            list.add(inT);
        }
        c.close();
        return list;
    }

    public void insert(String name) {
        dbHelper.queryData("INSERT INTO LoaiThu VALUES(null,'" + name + "')");
    }

    public void update(int id, String name) {
        dbHelper.queryData("UPDATE LoaiThu SET tenLoaiThu = '" + name + "' WHERE id = " + id);
    }

    public void delete(int id) {
        dbHelper.queryData("DELETE FROM LoaiThu WHERE id = '" + id + "'");
    }
}
