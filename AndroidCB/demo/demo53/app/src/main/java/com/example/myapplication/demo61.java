package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class demo61 extends AppCompatActivity {
    EditText txtId, txtName, txtQty;
    Button btnAdd, btnUpdate, btnDelete, btnShow;
    ListView lv;

    SanPhamDAO dao;
    ArrayAdapter<String> adapter;
    List<String> list = new ArrayList<>();
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo61);

        txtId = findViewById(R.id.ed_Id);
        txtName = findViewById(R.id.ed_Name);
        txtQty = findViewById(R.id.ed_SL);
        btnAdd = findViewById(R.id.btn_Them);
        btnUpdate = findViewById(R.id.btn_Sua);
        btnDelete = findViewById(R.id.btn_Xoa);
        btnShow = findViewById(R.id.btn_HienThi);
        lv = findViewById(R.id.lv_SP);

        dao = new SanPhamDAO(context);
        list.clear();
        list = dao.getAllSPtoString();
        adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);
        //Xử lý sự kiện show
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                list = dao.getAllSPtoString();
                adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, list);
                lv.setAdapter(adapter);
            }
        });

        //
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. tạo đối tượng
                SanPham sp = new SanPham();
                //2. đưa dữ liệu ngdùng nhập vào đối tượng
                sp.setId(txtId.getText().toString());
                sp.setName(txtName.getText().toString());
                sp.setQty(Integer.parseInt(txtQty.getText().toString()));
                //3.Thực thi insert
                int kq = dao.insertSP(sp);
                //4.kiểm tra kq
                if(kq==-1){
                    Toast.makeText(context, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }
                if (kq==1)
                    Toast.makeText(context, "Thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });

        //
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = txtId.getText().toString();
                int kq = dao.deleteSanPham(id);
                //4.kiểm tra kq
                if(kq==-1){
                    Toast.makeText(context, "Xoá thất bại", Toast.LENGTH_SHORT).show();
                }
                if (kq==1)
                    Toast.makeText(context, "Xoá thành công", Toast.LENGTH_SHORT).show();
            }
        });

        //
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. tạo đối tượng
                SanPham sp = new SanPham();
                //2. đưa dữ liệu ngdùng nhập vào đối tượng
                sp.setId(txtId.getText().toString());
                sp.setName(txtName.getText().toString());
                sp.setQty(Integer.parseInt(txtQty.getText().toString()));
                //3.Thực thi insert
                int kq = dao.updateSP(sp);
                //4.kiểm tra kq
                if(kq==-1){
                    Toast.makeText(context, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                }
                if (kq==1)
                    Toast.makeText(context, "Sửa thành công", Toast.LENGTH_SHORT).show();
            }
        });

    }
}