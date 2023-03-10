package com.example.sqlitedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private List<Student> list = new ArrayList<>();
    int layout;

    public StudentAdapter(Context context, List<Student> list, int layout) {
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
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            TextView txtId, txtName;
            txtId = convertView.findViewById(R.id.d61_edId);
            txtName = convertView.findViewById(R.id.d61_edName);

            txtId.setText(list.get(position).getId());
            txtName .setText(list.get(position).getName());
        }
        return convertView;
    }
}
