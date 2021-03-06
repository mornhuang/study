package com.huang.android.ch01;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.huang.android.R;

public class TestDimActivity extends Activity {
    private TextView myTextView;
    private Button myBtn;
    
    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l04_dim);
        
        myBtn = (Button)findViewById(R.id.l0401_button);
        
        Resources r = this.getResources();
        float btn_h = r.getDimension(R.dimen.btn_height);
        float btn_w = r.getDimension(R.dimen.btn_width);
        myBtn.setWidth((int)btn_w);
        myBtn.setHeight((int)btn_h);
        
        // 引用颜色资源，设置背景色为红色
        getWindow().setBackgroundDrawableResource(R.color.red_bg);
        
        myTextView = (TextView)findViewById(R.id.l0400_textView);
        String str = getString(R.string.dynamic_txt).toString();
        myTextView.setText(str);
    }

}

