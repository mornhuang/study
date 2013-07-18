package com.huang.android.ch04.show.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import com.huang.android.ch04.R;
import com.huang.android.ch04.transmit.data.Data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-15 下午4:19
 * Descriptions    :
 */
public class Main extends Activity implements View.OnClickListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn1 = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button1);
        Button btn3 = (Button) findViewById(R.id.button2);
        Button btn4 = (Button) findViewById(R.id.button3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.button:
                intent = new Intent(this, MyActivity1.class);
                startActivity(intent);
                break;

            case R.id.button1:
                intent = new Intent("myaction1");
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                Data clipData = new Data();
                clipData.id = 6666;
                clipData.name = "通过Clipboard传送的数据";
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                String base64Str = "";
                try {
                    ObjectOutputStream oos = new ObjectOutputStream(baos);
                    oos.writeObject(clipData);
                    base64Str = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clipboardManager.setText(base64Str);
                startActivity(intent);
                break;

            case R.id.button2:
                intent = new Intent("myaction2");
                intent.addCategory("mycategory");
                startActivity(intent);
                break;

            case R.id.button3:
                intent = new Intent(this, MyActivity4.class);
                startActivityForResult(intent, 1);   // 请求码为1
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:  /* 请求码为1 */
                switch (resultCode) {
                    case 2:   // 返回码为2
                        setTitle(data.getStringExtra("value"));
                        break;

                    default:
                        break;
                }

            default:
                break;
        }
    }
}