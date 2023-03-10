package com.example.studentmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.studentmanagement.R;
import com.example.studentmanagement.model.Student;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Student> list;
    private int layout;

    public StudentAdapter(Context context, ArrayList<Student> list, int layout) {
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
            TextView txtSttSt = convertView.findViewById(R.id.item_txtSttSS);
            TextView txtIdSt = convertView.findViewById(R.id.item_txtIdSS);
            TextView txtNameSt = convertView.findViewById(R.id.item_txtNameSS);
            TextView txtBitrhSt = convertView.findViewById(R.id.item_txtBirthSS);

            txtSttSt.setText("" + (position + 1));
            txtIdSt.setText(list.get(position).getId());
            txtNameSt.setText(list.get(position).getName());
            txtBitrhSt.setText(list.get(position).getBirth());
        } else {
            TextView txtSttSt = convertView.findViewById(R.id.item_txtSttSS);
            TextView txtIdSt = convertView.findViewById(R.id.item_txtIdSS);
            TextView txtNameSt = convertView.findViewById(R.id.item_txtNameSS);
            TextView txtBitrhSt = convertView.findViewById(R.id.item_txtBirthSS);

            txtSttSt.setText("" + (position + 1));
            txtIdSt.setText(list.get(position).getId());
            txtNameSt.setText(list.get(position).getName());
            txtBitrhSt.setText(list.get(position).getBirth());
        }
        return convertView;
    }


}
