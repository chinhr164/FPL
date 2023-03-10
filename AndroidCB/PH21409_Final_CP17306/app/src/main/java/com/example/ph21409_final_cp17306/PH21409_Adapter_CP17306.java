package com.example.ph21409_final_cp17306;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PH21409_Adapter_CP17306 extends BaseAdapter {
    private Context PH21409_context_CP17306;
    private int PH21409_layout_CP17306;
    private ArrayList<PH21409_Product_CP17306> PH21409_list_CP17306;

    public PH21409_Adapter_CP17306(Context PH21409_context_CP17306, int PH21409_layout_CP17306, ArrayList<PH21409_Product_CP17306> PH21409_list_CP17306) {
        this.PH21409_context_CP17306 = PH21409_context_CP17306;
        this.PH21409_layout_CP17306 = PH21409_layout_CP17306;
        this.PH21409_list_CP17306 = PH21409_list_CP17306;
    }

    @Override
    public int getCount() {
        return PH21409_list_CP17306.size();
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
            LayoutInflater inflater = (LayoutInflater) PH21409_context_CP17306.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(PH21409_layout_CP17306, null);

            TextView PH21409_tv_CP17306 = convertView.findViewById(R.id.PH21409_tv_CP17306);
            String PH21409_idType_CP17306 = PH21409_list_CP17306.get(position).getPH21409_IDtype_CP17306();
            String PH21409_idProduct_CP17306 = PH21409_list_CP17306.get(position).getPH21409_IDP_CP17306();
            String PH21409_price_CP17306 = PH21409_list_CP17306.get(position).getPH21409_Price_CP17306();
            String PH21409_qty_CP17306 = PH21409_list_CP17306.get(position).getPH21409_Qty_CP17306();
            String PH21409_date_CP17306 = PH21409_list_CP17306.get(position).getPH21409_Date_CP17306();
            PH21409_tv_CP17306.setText(PH21409_idType_CP17306 + "\t-\t"
                    + PH21409_idProduct_CP17306 + "\t-\t"
                    + PH21409_price_CP17306 + "\t-\t"
                    + PH21409_qty_CP17306 + "\t-\t"
                    + PH21409_date_CP17306);
        } else {
            TextView PH21409_tv_CP17306 = convertView.findViewById(R.id.PH21409_tv_CP17306);
            String PH21409_idType_CP17306 = PH21409_list_CP17306.get(position).getPH21409_IDtype_CP17306();
            String PH21409_idProduct_CP17306 = PH21409_list_CP17306.get(position).getPH21409_IDP_CP17306();
            String PH21409_price_CP17306 = PH21409_list_CP17306.get(position).getPH21409_Price_CP17306();
            String PH21409_qty_CP17306 = PH21409_list_CP17306.get(position).getPH21409_Qty_CP17306();
            String PH21409_date_CP17306 = PH21409_list_CP17306.get(position).getPH21409_Date_CP17306();
            PH21409_tv_CP17306.setText(PH21409_idType_CP17306 + "\t-\t"
                    + PH21409_idProduct_CP17306 + "\t-\t"
                    + PH21409_price_CP17306 + "\t-\t"
                    + PH21409_qty_CP17306 + "\t-\t"
                    + PH21409_date_CP17306);
        }

        return convertView;
    }
}

