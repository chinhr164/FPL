package com.zrapp.moneylover.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zrapp.moneylover.R;
import com.zrapp.moneylover.model.Expenses;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class exsAdapter extends RecyclerView.Adapter<exsHolder> {
    ArrayList<Expenses> list;
    int LAYOUT;
    Context context;

    public exsAdapter(ArrayList<Expenses> list, int LAYOUT, Context context) {
        this.list = list;
        this.LAYOUT = LAYOUT;
        this.context = context;
    }

    @NonNull
    @Override
    public exsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(LAYOUT, parent, false);
        exsHolder holder = new exsHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull exsHolder holder, int position) {
        Expenses exs = list.get(position);
        holder.tvName.setText(exs.getName());
        holder.tvPrice.setText(NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(exs.getPrice()));
        holder.tvUser.setText(exs.getUser());

        /* Bắt đầu xử lý ngày tháng */
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date objNgay = format.parse(exs.getDate());
            String date = (String) new SimpleDateFormat("dd-MM-yyyy").format(objNgay);
            holder.tvDate.setText(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /* Kết thúc xử lý ngày tháng */

        /* Bắt đầu xử lý ẩn/hiện thông tin */
        Animation animationUp = AnimationUtils.loadAnimation(context, R.anim.slide_up);
        Animation animationDown = AnimationUtils.loadAnimation(context, R.anim.slide_down);
        holder.ibtn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.layout.isShown()) {
                    holder.layout.setVisibility(View.GONE);
                    holder.layout.startAnimation(animationUp);
                    holder.ibtn_info.setImageResource(R.drawable.ic_collapse);
                } else {
                    holder.layout.setVisibility(View.VISIBLE);
                    holder.layout.startAnimation(animationDown);
                    holder.ibtn_info.setImageResource(R.drawable.ic_expand);
                }
            }
        });
        /* Kết thúc xử lý ẩn/hiện thông tin */
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
