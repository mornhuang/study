package com.huang.android.ch01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.huang.android.ch01.IPerson;

/**
 * Created by User : Morn
 * Created DateTime: 13-7-6 下午3:26
 */
public class SvrPersonRemote extends Service {
    private IPerson.Stub iPerson = new IPersonImpl();

    public IBinder onBind(Intent intent) {
        return iPerson;
    }
}
