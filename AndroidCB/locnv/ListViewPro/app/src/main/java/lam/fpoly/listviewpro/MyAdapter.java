package lam.fpoly.listviewpro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<FoodObject> list = new ArrayList<>();
    private int layout;

    public MyAdapter(Context mContext, ArrayList<FoodObject> list, int layout) {
        this.mContext = mContext;
        this.list = list;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public java.lang.Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //tại đây sẽ hình thành lên từng item một
        LayoutInflater mInflater = (LayoutInflater) mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = mInflater.inflate(layout,null);
            ImageView img = convertView.findViewById(R.id.idImg1);
            TextView name = convertView.findViewById(R.id.tv);
            TextView price = convertView.findViewById(R.id.gia);
            name.setText(list.get(position).getTenFood());
            price.setText(list.get(position).getPrice());
            img.setImageResource(list.get(position).getImages());
        }
        return convertView;
    }
}
