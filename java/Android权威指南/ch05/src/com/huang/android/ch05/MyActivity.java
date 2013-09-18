package com.huang.android.ch05;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // 手动解析
        TextView textView1 = (TextView) findViewById(R.id.textview1);

        String html = "<font color='Red'>I Love Android.</font><br>";
        html += "<font color='#0000FF'><big><i>I Love Android.</i></big></font><p>";
        html += "<font color='@" + android.R.color.white +
                "' ><tt><b><big><u>I Love Android.</u></big></b></tt></font><p>";
        html += "<big><a href='http://51happyblog.com'>我的网站:51happyblog.com</a></big>";

        CharSequence charSequence = Html.fromHtml(html);
        textView1.setText(charSequence);
        textView1.setMovementMethod(LinkMovementMethod.getInstance());

        // 自动解析
        TextView textView2 = (TextView) findViewById(R.id.textview2);

        String text = "我的URL: http://51happyblog.com\n";
        text += "我的Email: abcd@126.com\n";
        text += "我的电话: +86 0755-12345678";

        textView2.setText(text);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());

        // 图文混排
        TextView textView3 = (TextView) findViewById(R.id.textView3);
//        textView3.setTextColor(Color.BLACK);
//        textView3.setBackgroundColor(Color.WHITE);
        textView3.setTextSize(20);

        String html2 = "图像1<img src='image1'/>图像2<img src='image2'/>图像3<img src='image3'/><p>";
        html2 += "图像4<a href='http://51happyblog.com'><img src='image4'/></a>图像5<img src='image5'/>";

        CharSequence charSequence1 = Html.fromHtml(html2, new Html.ImageGetter() {
            @Override
            public Drawable getDrawable(String s) {
                Drawable drawable = getResources().getDrawable(getResourceId(s));
                if (s.equals("image3")) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth()/2, drawable.getIntrinsicHeight()/2);
                } else {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
                return drawable;
            }
        }, null);

        textView3.setText(charSequence1);
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public int getResourceId(String name) {
        try {
            Field field = R.drawable.class.getField(name);
            return Integer.parseInt(field.get(null).toString());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
