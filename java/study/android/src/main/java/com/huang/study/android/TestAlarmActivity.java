package com.huang.study.android;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-9 下午3:56
 * Descriptions    :
 */
public class TestAlarmActivity extends Activity {
    private static final String BC_ACTION = "com.huang.study.android.BC_ACTION";
    private Button setBtn,  cancelBtn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l22_alarm);

        setBtn = (Button) findViewById(R.id.l2201_button);
        cancelBtn = (Button) findViewById(R.id.l2202_button);

        final AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        Intent intent = new Intent();
        intent.setAction(BC_ACTION);
        intent.putExtra("msg", "你该开会了");
        final PendingIntent pi = PendingIntent.getBroadcast(TestAlarmActivity.this, 0, intent, 0);
        final long time = System.currentTimeMillis();

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.setRepeating(AlarmManager.RTC_WAKEUP, time, 2*1000, pi);
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.cancel(pi);
            }
        });

    }
}