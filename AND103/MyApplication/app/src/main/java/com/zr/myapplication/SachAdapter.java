package com.zr.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zr.myapplication.databinding.LayoutItemSachBinding;

import java.util.List;

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.SachHolder>{
  public interface OnClickListener{
    void onItemClick(Sach Sach, View v);
  }

  private List<Sach> list;
  private Context context;
  private OnClickListener onClickListener;

  public SachAdapter(List<Sach> list, Context context, OnClickListener onClickListener){
    this.list=list; this.context=context; this.onClickListener=onClickListener;
  }

  @NonNull
  @Override
  public SachHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    LayoutItemSachBinding binding=LayoutItemSachBinding.inflate(LayoutInflater.from(context), parent, false);
    return new SachHolder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull SachHolder holder, int position){
    holder.bind(list.get(position), onClickListener);
  }

  @Override
  public int getItemCount(){
    return list.size();
  }

  class SachHolder extends RecyclerView.ViewHolder{
    LayoutItemSachBinding binding;

    public SachHolder(@NonNull LayoutItemSachBinding binding){
      super(binding.getRoot()); this.binding=binding;
    }

    @SuppressLint("SetTextI18n")
    public void bind(Sach Sach, OnClickListener listener){
      binding.tv.setText(Sach.getMa_sach_ph21409()+" - "+
              Sach.getTieu_de_ph21409()+" - "+
              Sach.getTac_gia_ph21409()+"- "+
              Sach.getNam_xuat_ban_ph21409()+" - "+
              Sach.getSo_trang_ph21409()+" - "+
              Sach.getThe_loai_ph21409()+" - "+
              Sach.getSo_luong_ph21409()+" - "+
              Sach.getHinh_anh_ph21409()+" - "+
              Sach.getDon_gia_ph21409());
      itemView.setOnClickListener(v->{
        listener.onItemClick(Sach, itemView);
      });
    }
  }
}
