package com.zrapp.boardcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ZrBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Đã nhận Broadcast!!", Toast.LENGTH_LONG).show();
        Intent intent1 = new Intent(context,MainActivity2222222222222.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent1.putExtra("data","Dữ liệu trong Broadcast");
        context.startActivity(intent1);
    }
}
