package com.huang.j2ee.ch01.model;

import com.opensymphony.xwork2.conversion.impl.DefaultTypeConverter;

import java.util.Map;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-22 上午7:42
 * Descriptions    :
 */
public class UserConvert extends DefaultTypeConverter {
    @Override
    public Object convertValue(Map<String, Object> context, Object value, Class toType) {
        if (toType == User.class) {
            String[] params = (String[])value;

            User user = new User();
            String[] userValue = params[0].split(",");
            user.setName(userValue[0]);
            user.setPass(userValue[1]);

            return user;
        } else if (toType == String.class) {
            User user = (User)value;
            return "<" + user.getName() + "," + user.getPass() + ">";
        }

        return null;
    }
}
