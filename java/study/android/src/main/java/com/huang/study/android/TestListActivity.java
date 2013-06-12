package com.huang.study.android;

import android.R;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Morn
 * Date: 13-6-12
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class TestListActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Cursor c = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        startManagingCursor(c);

        ArrayList<String> n_v = new ArrayList<String>();

        if (c.getCount() > 0) {
            while (c.moveToNext()) {
                String id = c.getString(c.getColumnIndex(ContactsContract.Contacts._ID));
                System.out.println("ID: "+id);

                String name = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                System.out.println("Name: " + name);
                n_v.add(name);
            }
        }

        ListAdapter adapter = new SimpleCursorAdapter(this,
                R.layout.simple_list_item_1,
                c,
                new String[] {ContactsContract.Contacts.DISPLAY_NAME},
                new int[] {R.id.text1} );
        setListAdapter(adapter);
    }
}