package com.huang.android.ch05;

import android.text.TextPaint;
import android.text.style.CharacterStyle;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-22 下午5:24
 * Descriptions    :
 */
public class ColorSpan extends CharacterStyle {
    private int textColor, backgroundColor;

    public ColorSpan(int textColor, int backgroundColor) {
        this.textColor = textColor;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void updateDrawState(TextPaint textPaint) {
        textPaint.bgColor = this.backgroundColor;
        textPaint.setColor(this.textColor);
    }
}
