package com.huang.study.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-7 下午4:50
 * Descriptions    :
 */
public class TestBroadCastActivity extends Activity {
    private static final String MY_ACTION = "com.huang.study.android.MY_ACTION";
    private Button btn;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l20_broadcast);

        btn = (Button) findViewById(R.id.l2001button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(MY_ACTION);
                intent.putExtra("msg", "广播消息，请回复");
                sendBroadcast(intent);
            }
        });
    }
}