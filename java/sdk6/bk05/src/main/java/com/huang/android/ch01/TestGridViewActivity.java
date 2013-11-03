package com.huang.android.ch01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.huang.android.R;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-13 下午7:00
 */
public class TestGridViewActivity extends Activity {
    private GridView gv;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l13_gridview);

        gv = (GridView)findViewById(R.id.l1300_gridView);
        gv.setNumColumns(4);
        gv.setAdapter(new MyAdapter(this));

    }

    private class MyAdapter extends BaseAdapter {
        private Integer[] imgs = {
            R.drawable.d08_gallery_photo,
            R.drawable.d09_gallery_photo,
            R.drawable.d10_gallery_photo,
            R.drawable.d11_gallery_photo,
            R.drawable.d12_gallery_photo,
            R.drawable.d13_gallery_photo,
            R.drawable.d14_gallery_photo,
            R.drawable.d15_gallery_photo,

            R.drawable.d08_gallery_photo,
            R.drawable.d09_gallery_photo,
            R.drawable.d10_gallery_photo,
            R.drawable.d11_gallery_photo,
            R.drawable.d12_gallery_photo,
            R.drawable.d13_gallery_photo,
            R.drawable.d14_gallery_photo,
            R.drawable.d15_gallery_photo
        };

        Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return imgs.length;
        }

        public Object getItem(int item) {
            return item;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = null;

            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(45, 45));
                imageView.setAdjustViewBounds(false);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView)convertView;
            }

            imageView.setImageResource(imgs[position]);
            return imageView;
        }
    }
}