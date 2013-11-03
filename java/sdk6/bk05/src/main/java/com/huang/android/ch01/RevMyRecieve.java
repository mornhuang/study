package com.huang.android.ch01;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-7 下午4:56
 * Descriptions    :
 */
public class RevMyRecieve extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
