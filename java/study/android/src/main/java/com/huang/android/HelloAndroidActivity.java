package com.huang.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class HelloAndroidActivity extends Activity {

    private static String TAG = "android";
    private TextView myTextView;
    
    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate");
	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // 引用颜色资源，设置背景色为红色
//        getWindow().setBackgroundDrawableResource(R.color.red_bg);
        
        myTextView = (TextView)findViewById(R.id.textView2);
        String str = getString(R.string.dynamic_txt).toString();
        myTextView.setText(str);
        
        int i = R.layout.main;
        System.out.println(i);
    }

}

