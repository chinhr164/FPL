package com.example.listproduct;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PH21409_MainActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Product> list = new ArrayList<>();
    private ProductAdapter adapter;

    private EditText txtId, txtName, txtPrice;
    private Button btnAdd, btnUpdate, btnDelete, btnReset;
    SQLiteHelper db = new SQLiteHelper(this);
    ProductDAO productDAO;
    String TB_Name = "PRODUCT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add(new Product("P001", "Cơm chiên Hoàng Bào", "30000"));
        list.add(new Product("P002", "Rồng xanh vượt đại dương", "15000"));
        list.add(new Product("P003", "Vũ nữ chân dài", "45000"));

        SQLiteHelper db = new SQLiteHelper(this);
        db.QuerryData("DROP TABLE IF EXISTS " + TB_Name);
        db.QuerryData("CREATE TABLE " + TB_Name + "( id text PRIMARY KEY, name text,price text)");
        for (Product sp : list) {
            db.QuerryData("INSERT INTO PRODUCT VALUES('" + sp.getId() + "','" + sp.getName()
                    + "','" + sp.getPrice() + "')");
        }

        txtId = findViewById(R.id.edId);
        txtName = findViewById(R.id.edName);
        txtPrice = findViewById(R.id.edPrice);
        lv = findViewById(R.id.lv2);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtId.setText(list.get(position).getId());
                txtName.setText(list.get(position).getName());
                txtPrice.setText("" + list.get(position).getPrice());
            }
        });

        show();

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtId.getText().toString().equalsIgnoreCase("")
                        || txtName.getText().toString().equalsIgnoreCase("")
                        || txtPrice.getText().toString().equalsIgnoreCase("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PH21409_MainActivity.this);
                    builder.setTitle("Thông Báo");
                    builder.setMessage("Mời bạn nhập đủ thông tin!");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                } else {
                    try {
                        String Id = txtId.getText().toString();
                        String Name = txtName.getText().toString();
                        String Price = txtPrice.getText().toString();
                        db.QuerryData("INSERT INTO PRODUCT VALUES('" + Id + "','" + Name + "','" + Price + "')");
                        Toast.makeText(PH21409_MainActivity.this, "Insert thành công!", Toast.LENGTH_SHORT).show();
                        show();
                        clearForm();
                    } catch (Exception e) {
                        Toast.makeText(PH21409_MainActivity.this, "Đã tồn tại mã", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtId.getText().toString().equalsIgnoreCase("")
                        && txtName.getText().toString().equalsIgnoreCase("")
                        && txtPrice.getText().toString().equalsIgnoreCase("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PH21409_MainActivity.this);
                    builder.setTitle("Thông Báo");
                    builder.setMessage("Mời bạn chọn thông tin!");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                } else {
                    try {
                        String Id = txtId.getText().toString();
                        String Name = txtName.getText().toString();
                        String Price = txtPrice.getText().toString();
                        if (db.getData("SELECT *" +
                                " FROM " + TB_Name + " WHERE id='" + Id + "';").getCount() > 0) {
                            db.QuerryData("UPDATE " + TB_Name + " SET name='" + Name + "',price='" + Price
                                    + "' WHERE id='" + Id + "';");
                            Toast.makeText(PH21409_MainActivity.this, "UPDATE thành công!", Toast.LENGTH_SHORT).show();
                            show();
                            clearForm();
                        } else
                            Toast.makeText(PH21409_MainActivity.this, "Sản phẩm không tồn tại!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                    }
                }
            }
        });

        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtId.getText().toString().equalsIgnoreCase("")
                        && txtName.getText().toString().equalsIgnoreCase("")
                        && txtPrice.getText().toString().equalsIgnoreCase("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(PH21409_MainActivity.this);
                    builder.setTitle("Thông Báo");
                    builder.setMessage("Mời bạn chọn thông tin!");
                    builder.setPositiveButton("OK", null);
                    builder.show();
                } else {
                    try {
                        String Id = txtId.getText().toString();
                        if (db.getData("SELECT *" +
                                " FROM " + TB_Name + " WHERE id='" + Id + "';").getCount() > 0) {
                            db.QuerryData("DELETE FROM " + TB_Name + " WHERE id='" + Id + "';");
                            Toast.makeText(PH21409_MainActivity.this, "Delete thành công!", Toast.LENGTH_SHORT).show();
                        } else
                            Toast.makeText(PH21409_MainActivity.this, "Sản phẩm không tồn tại!", Toast.LENGTH_SHORT).show();
                        show();
                        clearForm();
                    } catch (Exception e) {
                    }
                }
            }
        });
    }

    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtPrice.setText("");
    }

    public void show() {
        Cursor c = db.getData("SELECT * FROM " + TB_Name );
        list.clear();
        while (c.moveToNext()) {
            String id = c.getString(0);
            String name = c.getString(1);
            String price = c.getString(2);
            list.add(new Product(id, name, price));
        }
        adapter = new ProductAdapter(this, list, R.layout.item_row);
        lv.setAdapter(adapter);
    }
}