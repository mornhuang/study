package com.huang.android.ch01;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-14 上午10:40
 * Descriptions    :
 */
public class TestProvideActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void query() {
        ContentResolver cr = getContentResolver();
        Uri uri = Uri.parse("content://contacts/people");
//        String[] projection = {ContactsContract.Contacts.}
    }
}