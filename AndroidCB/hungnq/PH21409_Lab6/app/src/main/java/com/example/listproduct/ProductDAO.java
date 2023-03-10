package com.example.listproduct;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    Context context;
    ArrayList<Product> list;
    SQLiteHelper db;
    ListView lv;
    ProductAdapter adapter;
    public String TB_Name;

    public ProductDAO(Context context, ArrayList<Product> list, ListView lv, String TB_Name, SQLiteHelper db) {
        this.context = context;
        this.list = list;
        this.lv = lv;
        this.TB_Name = TB_Name;
        this.db = db;
    }

    public void show() {
        Cursor c = db.getData("SELECT * FROM " + TB_Name);
        list.clear();
        while (c.moveToNext()) {
            String id = c.getString(0);
            String name = c.getString(1);
            String price = c.getString(2);
            list.add(new Product(id, name, price));

        }
        adapter = new ProductAdapter(context, list, R.layout.item_row);
        lv.setAdapter(adapter);
    }

    public void insert(String txtId, String txtName, String txtPrice) {
        db.QuerryData("INSERT INTO PRODUCT VALUES('" + txtId + "','" + txtName + "','" + txtPrice + "')");
        Toast.makeText(context, "Insert thành công!", Toast.LENGTH_SHORT).show();
    }

    public void update(String txtId, String txtName, String txtPrice) {
        if (db.getData("SELECT *" +
                " FROM " + TB_Name + " WHERE id='" + txtId + "';").getCount() > 0) {
            db.QuerryData("UPDATE " + TB_Name + " SET name='" + txtName + "',price='" + txtPrice
                    + "' WHERE id='" + txtId + "';");
            Toast.makeText(context, "UPDATE thành công!", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(context, "Sản phẩm không tồn tại!", Toast.LENGTH_SHORT).show();
    }

//    public void delete(String txtId) {
////        if (db.getData("SELECT *" +
//                " FROM " + TB_Name + " WHERE id='" + txtId + "';").getCount() > 0) {
//            db.QuerryData("DELETE " + TB_Name + " WHERE id='" + txtId + "';");
//            Toast.makeText(context, "Delete thành công!", Toast.LENGTH_SHORT).show();
////        } else
////            Toast.makeText(context, "Sản phẩm không tồn tại!", Toast.LENGTH_SHORT).show();
//    }
}