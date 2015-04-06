package com.huang.j2ee.ch00.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Field;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/5 15:30
 * Descriptions    : 测试BeanPostProcessor，熟悉Bean初始化流程
 */
public class Fuddifer implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                if (field.getType().equals(String.class)) {
                    field.setAccessible(true);  // 这样才对属性进行赋值操作
                    String original = (String) field.get(bean);
                    field.set(bean, fuddify(original));
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return bean;
    }

    private String fuddify(String original) {
        if (null == original) return null;
        return original.replaceAll("(r|l)", "w")
                .replaceAll("(R|L})", "W");
    }
}
