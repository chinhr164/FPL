package com.example.studentmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ClassAdapter extends ArrayAdapter<Classes> {
    private Context context;
    private int resource;
    private List<Classes> objects;
    private LayoutInflater inflater;

    public ClassAdapter(Context context, int resource, List<Classes> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_listview, null);

            holder = new ViewHolder();
            holder.txtSTT = convertView.findViewById(R.id.item_txtSTT);
            holder.txtId = convertView.findViewById(R.id.item_txtId);
            holder.txtName = convertView.findViewById(R.id.item_txtName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Classes s = objects.get(position);
        holder.txtSTT.setText(s.getStt());
        holder.txtId.setText(s.getId());
        holder.txtName.setText(s.getName());
        return convertView;
    }

    public class ViewHolder {
        TextView txtSTT, txtId, txtName;
    }

}
