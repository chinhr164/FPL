package com.example.customlv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Food> list;
    private int layout;

    public FoodAdapter(Context context, ArrayList<Food> list, int layout) {
        this.context = context;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Tại đây hình thành khuôn của tùng item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {//Nếu layout trống
            convertView = inflater.inflate(layout, null);
            ImageView img = convertView.findViewById(R.id.image);
            TextView txtName = convertView.findViewById(R.id.tvName);
            TextView txtPrice = convertView.findViewById(R.id.tvPrice);

            txtName.setText(list.get(position).getName());
            txtPrice.setText(String.valueOf(list.get(position).getPrice()));
            img.setImageResource(list.get(position).getImage());
        }
        return convertView;
    }
}
