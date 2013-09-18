package com.huang.android.ch05;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

/**
 * Created By User : Morn
 * Created DateTime: 13-7-22 下午3:23
 * Descriptions    :
 */
public class Span extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.span);

        TextView textView4 = (TextView) findViewById(R.id.textView4);
        TextView textView5 = (TextView) findViewById(R.id.textView5);

        String text1 = "显示Activity1";
        String text2 = "显示Activity2";

        SpannableString spannableString1 = new SpannableString(text1);
        SpannableString spannableString2 = new SpannableString(text2);

        spannableString1.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Span.this, Activity1.class);
                startActivity(intent);
            }
        }, 0, text1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString2.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Span.this, Activity2.class);
                startActivity(intent);
            }
        }, 2, text2.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableString2.setSpan(new ColorSpan(Color.WHITE, Color.BLUE), 0, 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView4.setText(spannableString1);
        textView5.setText(spannableString2);

        textView4.setMovementMethod(LinkMovementMethod.getInstance());
        textView5.setMovementMethod(LinkMovementMethod.getInstance());
    }
}