package com.huang.android;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-12 下午3:24
 * Descriptions    :
 */
public class TestSqlliteActivity extends Activity {
    private EditText et1, et2, et3;
    private Button btn1;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l25_sqllite);

        et1 = (EditText) findViewById(R.id.l2502_editText);
        et2 = (EditText) findViewById(R.id.l2504_editText);
        et3 = (EditText) findViewById(R.id.l2506_editText);

        btn1 = (Button) findViewById(R.id.l2507_button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et1.getText().toString();
                String url = et2.getText().toString();
                String desc = et3.getText().toString();

                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("url", url);
                values.put("desc", desc);

                ClsDBHelp dbHelp = new ClsDBHelp(getApplicationContext());
                dbHelp.insert(values);
                Intent intent = new Intent(TestSqlliteActivity.this, TestQueryActivity.class);
                startActivity(intent);
            }
        });
    }
}