package com.huang.android.ch02.first;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;

public class Main extends Activity {
    private CircleCanvas mCircleCanvas;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ViewGroup viewGroup = (ViewGroup) getLayoutInflater().inflate(R.layout.main, null);
        mCircleCanvas = new CircleCanvas(this);
        viewGroup.addView(mCircleCanvas, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 350));
        setContentView(viewGroup);
    }

    public void drawRandomCircle(View view) {
        Random random = new Random();
        float randomX = (float) (100 + random.nextInt(100));
        float randomY = (float) (100 + random.nextInt(100));
        float randomRadius = (float) (20 + random.nextInt(40));
        int randomColor = 0;

        if (random.nextInt(100) > 50) {
            randomColor = Color.BLUE;
        }  else {
             if (random.nextInt(100) > 50) {
                 randomColor = Color.RED;
             } else {
                 randomColor = Color.GREEN;
             }
        }

        CircleCanvas.CircleInfo circleInfo = new CircleCanvas.CircleInfo();
        circleInfo.setX(randomX);
        circleInfo.setY(randomY);
        circleInfo.setRadius(randomRadius);
        circleInfo.setColor(randomColor);

        mCircleCanvas.mCircleInfos.add(circleInfo);
        mCircleCanvas.invalidate();
    }

    public void clear(View view) {
        mCircleCanvas.mCircleInfos.clear();
        mCircleCanvas.invalidate();
    }
}
