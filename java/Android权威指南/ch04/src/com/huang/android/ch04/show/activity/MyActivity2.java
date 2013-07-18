package com.huang.android.ch04.show.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.util.Base64;
import android.widget.TextView;
import com.huang.android.ch04.R;
import com.huang.android.ch04.transmit.data.Data;

import java.io.*;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-15 下午4:19
 * Descriptions    :
 */
public class MyActivity2 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        String base64Str = clipboard.getText().toString();
        byte[] buffer = Base64.decode(base64Str, Base64.DEFAULT);
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            Data data = (Data) ois.readObject();
            ((TextView) findViewById(R.id.textView)).setText(base64Str + "\n\ndata.id: "
                    + data.id + "\ndata.name: " + data.name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (OptionalDataException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}