package com.huang.android;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleCursorAdapter;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-12 下午5:06
 * Descriptions    :
 */
public class TestQueryActivity extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("浏览收藏信息");
        final ClsDBHelp dbHelp = new ClsDBHelp(this);
        Cursor c = dbHelp.query();
        String[] from = {"_id", "name", "url", "desc"};
        int[] to = {R.id.l2601_textView, R.id.l2602_textView, R.id.l2603_textView, R.id.l2604_textView};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.l26_row, c, from, to);
        android.widget.ListView listView = getListView();
        listView.setAdapter(adapter);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final long temp = id;
                builder.setMessage("真的要删除该记录？").setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelp.delete((int) temp);
                        Cursor c = dbHelp.query();
                        String[] from = {"_id", "name", "url", "desc"};
                        int[] to = {R.id.l2601_textView, R.id.l2602_textView, R.id.l2603_textView, R.id.l2604_textView};

                        SimpleCursorAdapter adapter1 = new SimpleCursorAdapter(getApplicationContext(), R.layout.l26_row, c, from, to);
                        android.widget.ListView listView1 = getListView();
                        listView1.setAdapter(adapter1);
                    }
                }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog ad = builder.create();
                ad.show();
            }
        });
        dbHelp.close();
    }
}