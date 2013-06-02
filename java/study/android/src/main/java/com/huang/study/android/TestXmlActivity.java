package com.huang.study.android;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TestXmlActivity extends Activity {
	private static final String TAG = "安卓学习";
	private TextView myTextView;
	private Button myButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(TAG, "onCreate");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_xml);
		
		myTextView = (TextView)findViewById(R.id.textView201);
		myButton = (Button)findViewById(R.id.button201);
		myButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int counter = 0;
				
				StringBuilder sb = new StringBuilder("");
				Resources r = getResources();
				XmlResourceParser xrp = r.getXml(R.xml.test);
				try {
					while (xrp.getEventType() != XmlResourceParser.END_DOCUMENT) {
						if (xrp.getEventType() == XmlResourceParser.START_TAG) {
							String name = xrp.getName();
							if (name.equals("customer")) {
								counter++;
								sb.append("第" + counter +"条客户信息:" + "\n");
								sb.append(xrp.getAttributeValue(0) + "\n");
								sb.append(xrp.getAttributeValue(1) + "\n");
								sb.append(xrp.getAttributeValue(2) + "\n");
								sb.append(xrp.getAttributeValue(3) + "\n\n");
							} 
						} else if (xrp.getEventType() == XmlResourceParser.END_TAG) {
						} else if (xrp.getEventType() == XmlResourceParser.TEXT) {
						}
						
						xrp.nextTag();
					}
					
					myTextView.setText(sb.toString());
				} catch (XmlPullParserException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
