package com.huang.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-24 上午11:23
 */
public class TestNext1Activity extends Activity {
    private EditText usrName = null;
    private EditText usrPwd = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.l15_next1);

        usrName = (EditText) findViewById(R.id.l1500_editText);
        usrPwd = (EditText) findViewById(R.id.l1501_editText);

        findViewById(R.id.l1502_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = usrName.getText().toString();
                String pwd = usrPwd.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("name", name);;
                bundle.putString("pwd", pwd);;
                Intent intent = new Intent(TestNext1Activity.this, TestNext2Activity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle bundle = data.getExtras();
        String name = bundle.getString("name");
        String pwd = bundle.getString("pwd");
        usrName.setText(name);
    }
}