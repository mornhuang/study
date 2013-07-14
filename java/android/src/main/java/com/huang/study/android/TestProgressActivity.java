package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

/**
 * Created by HuangMeng on 13-6-7.
 */
public class TestProgressActivity extends Activity {
    private Button b1, b2;
    ProgressBar progressBar;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l08_progress);

        b1 = (Button)findViewById(R.id.l0801_button);
        b2 = (Button)findViewById(R.id.l0802_button);

        progressBar = (ProgressBar)findViewById(R.id.l0800_progressBar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.incrementProgressBy(-1);
            }
        });
    }
}