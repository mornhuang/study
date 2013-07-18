package com.huang.android.ch02.first;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-14 下午2:47
 * Descriptions    :
 */
public class CircleCanvas extends View {
    // 保存绘制历史
    public List<CircleInfo> mCircleInfos = new ArrayList<CircleInfo>();

    // 保存实心圆相关信息的类
    public static class CircleInfo {
        private float x;
        private float y;
        private float radius;
        private int color;

        public float getX() {
            return x;
        }

        public void setX(float x) {
            this.x = x;
        }

        public float getY() {
            return y;
        }

        public void setY(float y) {
            this.y = y;
        }

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }

        public float getRadius() {
            return radius;
        }

        public void setRadius(float radius) {
            this.radius = radius;
        }
    }

    public CircleCanvas(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (CircleInfo circleInfo : mCircleInfos) {
            Paint paint = new Paint();
            paint.setColor(circleInfo.getColor());
            canvas.drawCircle(circleInfo.getX(), circleInfo.getY(),
                    circleInfo.getRadius(), paint);
        }
    }
}
