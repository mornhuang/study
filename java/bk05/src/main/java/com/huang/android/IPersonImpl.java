package com.huang.android;

import android.os.RemoteException;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-30 下午10:36
 */
public class IPersonImpl extends IPerson.Stub {
    private int age;
    private String name;

    @Override
    public String display() throws RemoteException {
        return "name:" + name + "age:" + age;
    }

    @Override
    public void setAge(int age) throws RemoteException {
        this.age = age;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }
}
