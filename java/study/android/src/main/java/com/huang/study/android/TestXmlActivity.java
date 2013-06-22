package com.huang.study.android;

import java.io.IOException;

import com.huang.study.android.util.LogUtil;
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
	private TextView myTextView;
	private Button myButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.i(LogUtil._CLASS_(), LogUtil._FUNC_());
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.l12_xml);
		
		myTextView = (TextView)findViewById(R.id.l1201_textView);
		myButton = (Button)findViewById(R.id.l1200_button);
		myButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int counter = 0;
				
				StringBuilder sb = new StringBuilder("");
				Resources r = getResources();
				XmlResourceParser xrp = r.getXml(R.xml.x01_test);
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
						
						xrp.next();
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
