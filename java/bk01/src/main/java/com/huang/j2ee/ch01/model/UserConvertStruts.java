package com.huang.j2ee.ch01.model;

import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * Created By User : Morn
 * Created DateTime: 13-9-22 上午8:23
 * Descriptions    :
 */
public class UserConvertStruts extends StrutsTypeConverter {

    //实现将字符串类型转换成复合类型的方法
    public Object convertFromString(Map context
            , String[] values, Class toClass) {
        //创建一个User实例
        User user = new User();
        //只处理请求参数数组第一个数组元素，
        //并将该字符串以英文逗号分割成两个字符串
        String[] userValues = values[0].split(",");
        //为User实例赋值
        user.setName(userValues[0]);
        user.setPass(userValues[1]);
        //返回转换来的User实例
        return user;
    }

    //实现将复合类型转换成字符串类型的方法
    public String convertToString(Map context, Object o) {
        //将需要转换的值强制类型转换为User实例
        User user = (User) o;
        return "<" + user.getName() + ","
                + user.getPass() + ">";
    }

}
