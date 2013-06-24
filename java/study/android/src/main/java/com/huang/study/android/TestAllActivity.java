package com.huang.study.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-22 下午8:40
 */
public class TestAllActivity extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l00_all);

        ((Button) findViewById(R.id.l0000_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestAutoActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0001_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestBitmapActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0002_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestDateActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0003_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestDimActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0004_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestGallaryActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0005_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestGridViewActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0006_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestLayoutActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0007_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestListActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0008_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestMenuActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0009_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestProgressActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0010_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestTabActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0011_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestWidgetActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0012_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestXmlActivity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0013_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestNext1Activity.class);
                startActivity(intent);
            }
        });

        ((Button) findViewById(R.id.l0014_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestAllActivity.this, TestLifeCycleActivity.class);
                startActivity(intent);
            }
        });

    }
}