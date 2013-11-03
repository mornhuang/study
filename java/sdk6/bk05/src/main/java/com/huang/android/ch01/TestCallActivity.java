package com.huang.android.ch01;

import android.R;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-29 上午8:13
 */
public class TestCallActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] menus = {"查看电话信息","编辑电话信息","显示拨打电话界面","直接打电话"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.simple_list_item_1, menus));
        getListView().setTextFilterEnabled(true);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent();
        Uri uri;
        String data;

        switch (position) {
            case 0:
                data = "content://contacts/people/1";
                uri = Uri.parse(data);
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
                break;

            case 1:
                data = "content://contacts/people/1";
                uri = Uri.parse(data);
                intent.setAction(Intent.ACTION_EDIT);
                intent.setData(uri);
                startActivity(intent);
                break;

            case 2:
                data = "tel:18925206506";
                uri = Uri.parse(data);
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(uri);
                startActivity(intent);
                break;

            case 3:
                data = "tel:18925206506";
                uri = Uri.parse(data);
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(uri);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}