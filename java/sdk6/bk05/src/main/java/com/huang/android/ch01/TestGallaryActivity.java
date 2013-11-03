package com.huang.android.ch01;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.*;
import com.huang.android.R;

/**
 * Created by User : Morn
 * Created DateTime: 13-6-15 下午3:12
 */
public class TestGallaryActivity extends Activity
        implements AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory {
    private ImageSwitcher mSwitcher;
    private Integer[] mThumbIds = {
        R.drawable.d16_sample_thumb, R.drawable.d17_sample_thumb,
        R.drawable.d18_sample_thumb, R.drawable.d19_sample_thumb,
        R.drawable.d20_sample_thumb, R.drawable.d21_sample_thumb,
        R.drawable.d22_sample_thumb, R.drawable.d23_sample_thumb
    };
    private Integer[] mImageIds = {
        R.drawable.d16_sample, R.drawable.d17_sample,
        R.drawable.d18_sample, R.drawable.d19_sample,
        R.drawable.d20_sample, R.drawable.d21_sample,
        R.drawable.d22_sample, R.drawable.d23_sample_thumb
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.l14_gallary);

        mSwitcher = (ImageSwitcher) findViewById(R.id.l1400_switcher);
        mSwitcher.setFactory(this);
        mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_in));
        mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));
        Gallery g = (Gallery) findViewById(R.id.l1400_gallery);
        g.setAdapter(new ImageAdapter(this));
        g.setOnItemSelectedListener(this);

    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
            i.setImageResource(mThumbIds[position]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            i.setBackgroundResource(R.drawable.d24_picture_frame);
            return i;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mSwitcher.setImageResource(mImageIds[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View makeView() {
        ImageView i = new ImageView(this);

        i.setBackgroundColor(0xff000000);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(Gallery.LayoutParams.FILL_PARENT,
                Gallery.LayoutParams.FILL_PARENT));

        return i;
    }
}