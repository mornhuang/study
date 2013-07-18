package com.huang.android.ch04.show.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.huang.android.ch04.R;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-16 上午10:45
 * Descriptions    :
 */
public class MyActivity4 extends Activity {
    private EditText editText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity4);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void onClick_Button(View view) {
        String value = editText.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("value", value);
        setResult(2, intent);       // 设置返回码为２
        finish();
    }
}