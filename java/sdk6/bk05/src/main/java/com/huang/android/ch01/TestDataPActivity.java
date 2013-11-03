package com.huang.android.ch01;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import com.huang.android.R;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-9 下午5:06
 * Descriptions    :
 */
public class TestDataPActivity extends Activity {
    private static final String TMP_SMS = "temp_sms";
    private EditText editText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l23_datap);

        editText = (EditText) findViewById(R.id.l2301_editText);
        SharedPreferences pre = getSharedPreferences(TMP_SMS, MODE_WORLD_READABLE);
        String content = pre.getString("sms_content", "");
        editText.setText(content);

    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor editor = getSharedPreferences(TMP_SMS, MODE_WORLD_WRITEABLE).edit();
        editor.putString("sms_content", editText.getText().toString());
        editor.commit();
    }
}