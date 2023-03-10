package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class Demo51Adapter extends ArrayAdapter<Product> {
    private Context context;
    private int resource;
    private List<Product> objects;
    private LayoutInflater inflater; //dịch vụ tạo layout trắng;

    public Demo51Adapter(Context context, int resource, List<Product> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //gọi getView

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Tạo Layout và gán TextView, Image vào Layout
        Demo51Holder holder;
        if (convertView == null) {
            //1.1 Tạo layout trắng
            convertView = inflater.inflate(R.layout.item_row, null);
            //ánh xạ các textview
            holder = new Demo51Holder();
            holder.img = convertView.findViewById(R.id.imageView);
            holder.tvName = convertView.findViewById(R.id.demo51_tv1);
            holder.tvPrice = convertView.findViewById(R.id.demo51_tv2);
            //Tạo template để sau dùng
            convertView.setTag(holder);
        } else {    //nếu có săn thì dùng
            holder = (Demo51Holder) convertView.getTag();
        }

        // 2. Gán dữ liệu
        Product p = objects.get(position);
        holder.img.setImageResource(p.getImage());
        holder.tvName.setText(p.getName());
        holder.tvPrice.setText(String.valueOf(p.getPrice()));
        return convertView;
    }


    //Tạo lớp ánh xạ
    public class Demo51Holder {
        ImageView img;
        TextView tvName, tvPrice;
    }
}
