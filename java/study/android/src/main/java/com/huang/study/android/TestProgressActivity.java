package com.huang.study.android;

import android.app.Activity;
import android.os.Bundle;
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
        setContentView(R.layout.test_progress);

        b1 = (Button)findViewById(R.id.button81);
        b2 = (Button)findViewById(R.id.button82);

    }
}