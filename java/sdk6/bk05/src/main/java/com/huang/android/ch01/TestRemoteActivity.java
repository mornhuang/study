package com.huang.android.ch01;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.huang.android.ch01.IPerson;
import com.huang.android.R;

/**
 * Created by User : Morn
 * Created DateTime: 13-7-6 下午3:31
 */
public class TestRemoteActivity extends Activity {
    private IPerson iPerson;
    private Button btn;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        synchronized public void onServiceConnected(ComponentName name, IBinder service) {
            iPerson = IPerson.Stub.asInterface(service);
            if (iPerson != null) {
                try {
                    iPerson.setName("hz.guo");
                    iPerson.setAge(32);
                    String msg = iPerson.display();
                    Toast.makeText(TestRemoteActivity.this, msg, Toast.LENGTH_LONG).show();
                } catch (android.os.RemoteException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.l19_service);

        btn = (Button) findViewById(R.id.l1904_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.huang.android.REMOTE_SERVICE");
                bindService(intent, conn, BIND_AUTO_CREATE);
            }
        });
    }
}