package com.zrapp.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class CallBroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra = intent.getExtras();
        if (extra != null) {
            String state = extra.getString(TelephonyManager.EXTRA_STATE);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = extra.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.i("phoneNumber", "onReceive: "+phoneNumber);
                Toast.makeText(context, phoneNumber, Toast.LENGTH_LONG).show();
            }
        }
    }

}
