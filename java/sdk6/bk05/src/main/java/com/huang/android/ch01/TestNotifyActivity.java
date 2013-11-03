package com.huang.android.ch01;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.huang.android.R;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-7 下午9:47
 * Descriptions    :
 */
public class TestNotifyActivity extends Activity {
    private Button sendBtn, cancelBtn;
    private Notification n;
    private NotificationManager nm;
    private static final int ID = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l21_notify);

        sendBtn = (Button) findViewById(R.id.l2101_button);
        cancelBtn = (Button) findViewById(R.id.l2102_button);

        String service = NOTIFICATION_SERVICE;
        nm = (NotificationManager) getSystemService(service);

        n = new Notification();
        n.icon = R.drawable.d06_launcher;
        n.tickerText = "Test Notification";
        n.when = System.currentTimeMillis();

        sendBtn.setOnClickListener(sendListener);
        cancelBtn.setOnClickListener(cancelListener);
    }

    private View.OnClickListener sendListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TestNotifyActivity.this, TestNotifyActivity.class);
            PendingIntent pi = PendingIntent.getActivity(TestNotifyActivity.this, 0, intent, 0);
            n.setLatestEventInfo(TestNotifyActivity.this, "My Title", "My Content", pi);
            nm.notify(ID, n);
        }
    };

    private View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            nm.cancel(ID);
        }
    };
}