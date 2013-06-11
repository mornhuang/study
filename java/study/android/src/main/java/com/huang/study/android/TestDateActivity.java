package com.huang.study.android;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: HuangMeng
 * Date: 13-6-9
 * Time: 下午2:58
 * To change this template use File | Settings | File Templates.
 */
public class TestDateActivity extends Activity {
    private Button b1, b2;
    private TextView tv1, tv2;
    private Calendar c;
    private int m_year, m_month, m_day, m_hour, m_minute;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l03_date);

        c = Calendar.getInstance();
        m_year = c.get(Calendar.YEAR);
        m_month = c.get(Calendar.MONTH);
        m_day = c.get(Calendar.DAY_OF_MONTH);
        m_hour = c.get(Calendar.HOUR);
        m_minute = c.get(Calendar.MINUTE);

        tv1 = (TextView)findViewById(R.id.l0300_textView);
        tv2 = (TextView)findViewById(R.id.l0301_textView);
        tv1.setText(m_year + ":" + m_month + ":" + m_day);
        tv2.setText(m_hour + ":" + m_minute);

        b1 = (Button)findViewById(R.id.l0302_button);
        b2 = (Button)findViewById(R.id.l0303_button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(1);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (0 == id) {
            return new DatePickerDialog(this, l1, m_year, m_month, m_day);
        } else {
            return new TimePickerDialog(this, l2, m_hour, m_minute, false);
        }
    }

    private DatePickerDialog.OnDateSetListener l1 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            m_year = year;
            m_month = monthOfYear;
            m_day = dayOfMonth;
            tv1.setText(m_year + ":" + m_month + ":" + m_day);
        }
    };

    private TimePickerDialog.OnTimeSetListener l2 = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            m_hour = hourOfDay;
            m_minute = minute;
            tv2.setText(m_hour + ":" + m_minute);
        }
    };

}