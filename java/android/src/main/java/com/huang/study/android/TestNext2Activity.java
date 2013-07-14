package com.huang.study.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-24 上午11:23
 */
public class TestNext2Activity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.l16_next2);

        Bundle bundle = getIntent().getExtras();
        ((TextView) findViewById(R.id.l1600_textView)).setText(bundle.getString("name"));
        ((TextView) findViewById(R.id.l1601_textView)).setText(bundle.getString("pwd"));

        findViewById(R.id.l1602_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                TestNext2Activity.this.setResult(0, intent);
                TestNext2Activity.this.finish();
            }
        });

    }
}