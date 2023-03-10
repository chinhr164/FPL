package com.example.listproduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> list = new ArrayList<>();
    int layout;

    public ProductAdapter(Context context, ArrayList<Product> list, int layout) {
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
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
            TextView txtName = convertView.findViewById(R.id.tvName);
            TextView txtPrice = convertView.findViewById(R.id.tvPrice);
            ImageView img = convertView.findViewById(R.id.image);

            txtName.setText(list.get(position).getName());
            txtPrice.setText(String.valueOf(list.get(position).getPrice()));
            img.setImageResource(list.get(position).getImg());

        } else {
            TextView txtName = convertView.findViewById(R.id.tvName);
            TextView txtPrice = convertView.findViewById(R.id.tvPrice);
            ImageView img = convertView.findViewById(R.id.image);

            txtName.setText(list.get(position).getName());
            txtPrice.setText(String.valueOf(list.get(position).getPrice()));
            img.setImageResource(list.get(position).getImg());
        }
        return convertView;
    }


}
