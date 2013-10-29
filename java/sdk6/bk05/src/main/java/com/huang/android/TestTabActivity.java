package com.huang.android;

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

        LayoutInflater.from(this).inflate(R.layout.l09_tab, th.getTabContentView(), true);
        th.addTab(th.newTabSpec("all").setIndicator("所有通话记录").setContent(R.id.l0901_textView));
        th.addTab(th.newTabSpec("ok").setIndicator("已接来电").setContent(R.id.l0902_textView));
        th.addTab(th.newTabSpec("cancel").setIndicator("示接来电").setContent(R.id.l0903_textView));
    }
}
