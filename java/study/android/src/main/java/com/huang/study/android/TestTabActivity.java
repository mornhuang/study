package com.huang.study.android;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

/**
 * Created by HuangMeng on 13-6-7.
 */
public class TestTabActivity extends TabActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost th = getTabHost();

        LayoutInflater.from(this).inflate(R.layout.test_tab, th.getTabContentView(), true);
        th.addTab(th.newTabSpec("all").setIndicator("所有通话记录").setContent(R.id.textView91));
        th.addTab(th.newTabSpec("ok").setIndicator("已接来电").setContent(R.id.textView92));
        th.addTab(th.newTabSpec("cancel").setIndicator("示接来电").setContent(R.id.textView93));
    }
}
