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
    private ArrayList<Product> list;
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
            TextView txtId = convertView.findViewById(R.id.tvId);
            TextView txtName = convertView.findViewById(R.id.tvName);
            TextView txtPrice = convertView.findViewById(R.id.tvPrice);

            txtId.setText(list.get(position).getId());
            txtName.setText(list.get(position).getName());
            txtPrice.setText(list.get(position).getPrice());

        } else {
            TextView txtId = convertView.findViewById(R.id.tvId);
            TextView txtName = convertView.findViewById(R.id.tvName);
            TextView txtPrice = convertView.findViewById(R.id.tvPrice);

            txtId.setText(list.get(position).getId());
            txtName.setText(list.get(position).getName());
            txtPrice.setText(list.get(position).getPrice());
        }
        return convertView;
    }


}
