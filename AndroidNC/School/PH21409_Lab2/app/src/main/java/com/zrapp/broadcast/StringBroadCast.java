package com.zrapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class StringBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra = intent.getExtras();
        String str = extra.getString("str");
        if (str.equals(""))
            Toast.makeText(context, "Đã nhập gì đâu >.<!", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }
}
