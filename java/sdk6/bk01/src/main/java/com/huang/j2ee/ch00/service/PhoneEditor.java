package com.huang.j2ee.ch00.service;

import java.beans.PropertyEditorSupport;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/5 17:56
 * Descriptions    :
 */
public class PhoneEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String stripped = stripNonNumeric(text);

        String areaCode = stripped.substring(0, 3);
        String prefix = stripped.substring(3, 6);
        String number = stripped.substring(6);

        PhoneNumber phone = new PhoneNumber(areaCode, prefix, number);
        setValue(phone);
    }

    private String stripNonNumeric(String text) {
        StringBuffer allNumeric = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char c  = text.charAt(i);
            if (Character.isDigit(c)) {
                allNumeric.append(c);
            }
        }

        return allNumeric.toString();
    }
}
