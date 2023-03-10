package com.example.chinhcvph21409_lab3_01;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    ArrayList<User> list;
    int LAYOUT;
    Context context;

    public UserAdapter(ArrayList<User> list, int LAYOUT, Context context) {
        this.list = list;
        this.LAYOUT = LAYOUT;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View row = inflater.inflate(LAYOUT, parent, false);
        UserViewHolder holder = new UserViewHolder(row);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = list.get(position);
        holder.user_info.setText(user.getId() + " - " + user.getName());

        //chuyển đổi byte[] -> bitmap
        byte[] img = user.getImg_res();
        Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
        holder.img_res.setImageBitmap(bitmap);

        holder.ibtn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View mainView = new View(context);
                Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.dialog_update_user);
                mainView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        dialog.dismiss();
                        return true;
                    }
                });

                TextView dialogTxtName = dialog.findViewById(R.id.dialog_edit_txtName);

                Button dialogBtnClear = dialog.findViewById(R.id.dialog_edit_btnClear);
                dialogBtnClear.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialogTxtName.setText("");
                    }
                });


                Button dialogBtnSave = dialog.findViewById(R.id.dialog_edit_btnSave);
                dialogBtnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = dialogTxtName.getText().toString().trim();

                        if (name.isEmpty())
                            Toast.makeText(context, "Vui lòng điền đủ thông tin", Toast.LENGTH_LONG).show();
                        else {
                            MainActivity.db.QueryData("UPDATE User SET Name = '" + name + "' WHERE Id = " + user.getId());
                            MainActivity.Show();
                            Toast.makeText(context, "Sửa thành công!!", Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                        }
                    }
                });
                dialog.show();
            }
        });

        holder.ibtn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.db.QueryData("DELETE FROM User WHERE Id = '" + user.getId()+"'");
                MainActivity.Show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
