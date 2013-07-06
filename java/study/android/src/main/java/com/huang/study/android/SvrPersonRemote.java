package com.huang.study.android;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

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
