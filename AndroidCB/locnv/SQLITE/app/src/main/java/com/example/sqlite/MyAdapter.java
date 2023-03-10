package com.example.sqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Student> listStudent = new ArrayList<>();
    private int layout;

    public MyAdapter(Context context, ArrayList<Student> listStudent, int layout) {
        this.context = context;
        this.listStudent = listStudent;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return listStudent.size();
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
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null){
            LayoutInflater Inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = Inflater.inflate(layout,null);
            TextView tvName = view.findViewById(R.id.tvTen);
            TextView tvMa = view.findViewById(R.id.tvMa);
            TextView tvID = view.findViewById(R.id.tvId);

            tvID.setText(""+listStudent.get(i).getId());
            tvMa.setText(listStudent.get(i).getMaSV());
            tvName.setText(listStudent.get(i).getTenSV());
        }

        return view;
    }
}
