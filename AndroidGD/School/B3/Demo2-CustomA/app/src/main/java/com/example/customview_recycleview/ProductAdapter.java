package com.example.customview_recycleview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    ArrayList<Product> list = new ArrayList<>();

    public ProductAdapter(ArrayList<Product> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return list.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //Khai báo biến View để tuỳ chỉnh cho hiển thị
        View row;
        if (view == null) {
            row = View.inflate(viewGroup.getContext(), R.layout.layout_item, null);
        } else {
            row = view;
        }

        //gán dữ liệu ở đây
        Product p = list.get(i);
        //Ánh xạ view
        ImageView img_res = row.findViewById(R.id.img_prod);
        TextView tv_name = row.findViewById(R.id.prod_info);
        ImageView delete_prod = row.findViewById(R.id.delete_prod);

        img_res.setImageResource(p.getImg_res());
        tv_name.setText(p.getId() + " - " + p.getName());
        delete_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //xoá
                list.remove(i);
                notifyDataSetChanged();
            }
        });

        return row; //phải sửa return null thành row
    }
}
