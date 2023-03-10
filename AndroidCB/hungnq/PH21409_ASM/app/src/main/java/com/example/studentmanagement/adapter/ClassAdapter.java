package com.example.studentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studentmanagement.model.Classes;
import com.example.studentmanagement.R;

import java.util.ArrayList;

public class ClassAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Classes> list;
    private int layout;

    public ClassAdapter(Context context, ArrayList<Classes> list, int layout) {
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
         if (convertView == null) {
             LayoutInflater inflater =
                     (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
             convertView = inflater.inflate(layout, null);

            TextView txtSTT = convertView.findViewById(R.id.item_txtSTT);
            TextView txtId = convertView.findViewById(R.id.item_txtId);
            TextView txtName = convertView.findViewById(R.id.item_txtName);

            txtSTT.setText(""+(position+1));
            txtId.setText(list.get(position).getId());
            txtName.setText(list.get(position).getName());
        } else {
            TextView txtSTT = convertView.findViewById(R.id.item_txtSTT);
            TextView txtId = convertView.findViewById(R.id.item_txtId);
            TextView txtName = convertView.findViewById(R.id.item_txtName);

            txtSTT.setText(""+(position+1));
            txtId.setText(list.get(position).getId());
            txtName.setText(list.get(position).getName());
        }
        return convertView;
    }

}
