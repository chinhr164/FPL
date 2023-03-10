package com.example.test1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ZrAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<CalendalObj> list = new ArrayList<>();
    private ZrDatabase db;


    public ZrAdapter(Context context, int layout, ArrayList<CalendalObj> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
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
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(layout, null);

            TextView contentT = convertView.findViewById(R.id.main_tvContent);
            TextView timeT = convertView.findViewById(R.id.main_tvTime);
            ImageButton img = convertView.findViewById(R.id.main_btnDelete);


            contentT.setText(list.get(position).getContentT());
            timeT.setText(list.get(position).getTimeT());
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder dialogB = new AlertDialog.Builder(context);
                    dialogB.setTitle("Thông báo");
                    dialogB.setMessage("Chắc chắn xóa?");
                    dialogB.setPositiveButton("Hủy", null);
                    dialogB.setNegativeButton("Xác nhận", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            db = new ZrDatabase(context);
                            Cursor c0 = db.getData("SELECT * FROM " + MainActivity.TB_NAME);
                            c0.moveToPosition(position);
                            int ID = c0.getInt(0);
                            db.queryData("DELETE FROM " + MainActivity.TB_NAME + " WHERE id=" + ID);
                            Toast.makeText(context, "Xóa thành công", Toast.LENGTH_LONG).show();
                            list.clear();
                            Cursor c = db.getData("SELECT * FROM " + MainActivity.TB_NAME);
                            while (c.moveToNext()) {
                                String contentT = c.getString(1);
                                String timeT = c.getString(2);
                                list.add(new CalendalObj(contentT, timeT));
                            }
                            c.close();
                            MainActivity.adapter = new ZrAdapter(context, R.layout.item_row, list);
                            MainActivity.lv.setAdapter(MainActivity.adapter);
                        }
                    });
                    AlertDialog dialog = dialogB.create();
                    dialog.show();
                }
            });
        }
        return convertView;
    }
}
