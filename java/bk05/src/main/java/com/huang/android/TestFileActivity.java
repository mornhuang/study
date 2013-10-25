package com.huang.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-10 下午3:40
 * Descriptions    :
 */
public class TestFileActivity extends Activity {
    private static final String FILE_NAME = "temp.txt";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l24_file);

        findViewById(R.id.l2402_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write(((EditText)findViewById(R.id.l2401_editText)).getText().toString());
            }
        });

        findViewById(R.id.l2404_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((TextView)findViewById(R.id.l2403_textView)).setText(read());
            }
        });
    }

    private String read() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            return new String(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void write(String s) {
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME, MODE_APPEND);
            fos.write(s.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}