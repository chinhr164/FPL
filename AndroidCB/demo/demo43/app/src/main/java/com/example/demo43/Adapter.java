package com.example.demo43;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.List;

public class Adapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact> objects;
    private LayoutInflater inflater;//biến vẽ layout

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Adapter(@NonNull Context context, int resource, List<Contact> objects) {
        super(context, resource, objects);
        this.context = context;
        this.objects = objects;
        this.resource = resource;
        //khởi tạo vẽ layout
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1.Tạo view
        MyViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.itemrow, null);//Tạo khung layout
            holder = new MyViewHolder();
            holder.tvColor = convertView.findViewById(R.id.tv1);
            holder.tvName = convertView.findViewById(R.id.tv2);
            holder.tvPhone = convertView.findViewById(R.id.tv3);
            convertView.setTag(holder);
        } else {
            holder = (MyViewHolder) convertView.getTag();
        }

        //2.Gán dữ liệu
        Contact c = objects.get(position);
        holder.tvColor.setBackgroundColor(c.getColor());
        holder.tvName.setText(c.getName());
        holder.tvPhone.setText(c.getPhone());
        return convertView;
    }

    //Tạo lớp ánh xạ với layout
    public class MyViewHolder {
        TextView tvColor, tvName, tvPhone;
    }
}
