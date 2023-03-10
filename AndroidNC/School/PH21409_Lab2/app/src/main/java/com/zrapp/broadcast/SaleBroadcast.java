package com.zrapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SaleBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra = intent.getExtras();
        String str = extra.getString("str");
        if (str.isEmpty())
            Toast.makeText(context, "Đã nhập gì đâu >.<!", Toast.LENGTH_LONG).show();
        else if (!(str.length() == 9))
            Toast.makeText(context, "Chuỗi nhập vào phải có 9 ký tự", Toast.LENGTH_LONG).show();
        else if (str.substring(0, 3).equals("MEM") || str.substring(0, 3).equals("VIP")) {
            if (str.equals("MEM537128"))
                Toast.makeText(context, "Khuyến mãi 10%", Toast.LENGTH_LONG).show();
            else if (str.equals("MEM537129"))
                Toast.makeText(context, "Khuyến mãi 20%", Toast.LENGTH_LONG).show();
            else if (str.equals("VIP537128"))
                Toast.makeText(context, "Khuyến mãi 30%", Toast.LENGTH_LONG).show();
            else if (str.equals("VIP537129"))
                Toast.makeText(context, "Khuyến mãi 50%", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context, "Không có khuyến mãi", Toast.LENGTH_LONG).show();
        } else
//            Toast.makeText(context, str.substring(0), Toast.LENGTH_LONG).show();
            Toast.makeText(context, "Chuỗi phải bắt đầu bằng \"MEM\" hoặc \"VIP\"", Toast.LENGTH_LONG).show();
    }
}
