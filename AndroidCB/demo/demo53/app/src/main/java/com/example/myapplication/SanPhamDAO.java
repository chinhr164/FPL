package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    private Context context;
    private SQLiteHelper dbHelper;
    private SQLiteDatabase db;

    //1.Khởi tạo
    public SanPhamDAO(Context context) {
        this.context = context;
        this.dbHelper = new SQLiteHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    //2.Thêm dữ liệu
    public int insertSP(SanPham s) {
        //2.1 - Tạo đối tượng chứa dữ liệu
        ContentValues values = new ContentValues();
        values.put("id", s.getId());
        values.put("name", s.getName());
        values.put("qyt", s.getQty());

        long kq = db.insert("SanPham", null, values);
        if (kq <= 0) {
            return -1;
        }
        return 1;
    }

    //3. Đọc dữ liệu
    public List<String> getAllSPtoString() {
        //3.1 - Tạo danh sách trống
        List<String> list = new ArrayList<>();
        //3.2 - Tạo con trỏ dữ liệu
        Cursor c = db.query("SanPham", null, null, null,
                null, null, null);
        //3.3 - Di chuyển con trỏ về đầu tiên
        c.moveToFirst();
        //3.4 - Đọc dữ liệu qua vòng lặp While
        while (c.isAfterLast() == false) {
            //3.4.1 - Tạo đối tượng chứa dữ liệu
            SanPham sp = new SanPham();
            //3.4.2 - Đưa từng trường dữ liệu đọc được vào đối tượng
            sp.setId(c.getString(0));
            sp.setName(c.getString(1));
            sp.setQty(c.getInt(2));
            //3.4.3 - Chuyển tất cả sang chuỗi
            String chuoi = sp.getId() + " - " + sp.getName() + " - " + sp.getQty();
            //3.4.4 - Đưa vào chuỗi
            list.add(chuoi);
            //3.4.5 - Di chuyển sang bản ghi tiếp theo
            c.moveToNext();
        }
        //2.5 đóng con trỏ
        c.close();
        return list;
    }

    //4. Xoa
    public int deleteSanPham(String id)
    {
        //delete(tenBang,dieuKien,ThamSoTruyen)
        int kq = db.delete("SanPham","id=?",
                new String[]{id});
        //kiem tra ket qua
        if(kq<=0)
        {
            return -1;
        }
        return 1;
    }

    public int updateSP(SanPham s) {
        //5.1 - Tạo đối tượng chứa dữ liệu
        ContentValues values = new ContentValues();
        values.put("id", s.getId());
        values.put("name", s.getName());
        values.put("qyt", s.getQty());

        long kq = db.update("SanPham", values,"id=?",
                new String[]{s.getId()});
        if (kq <= 0) {
            return -1;
        }
        return 1;
    }


}
