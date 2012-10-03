package com.huang.study.base;

import java.lang.reflect.Method;

public abstract class BaseVO {
	/**
	 * 对象是否为空,遍历各个Get方法，如果有返回值就不是空类
	 * 
	 * @Time 2009-9-25 上午10:40:34 create
	 * @return
	 * @author maoliang
	 */
	public boolean isEmpty() {
		Method[] methods = this.getClass().getMethods();
		for (Method m : methods) {
			System.out.println(m);
			System.out.println(m.getName().indexOf("get"));
			System.out.println(m.getName().indexOf("getClass"));
			if (0 == m.getName().indexOf("get")
					&& m.getName().indexOf("getClass") < 0) {
				try {
					if (null != m.invoke(this)) {
						return false;
					}
				} catch (Exception e) {
					// 什么都不做，只要有一个get方法能返回值，就不是空的了！
				}
			}
		}
		return true;
	}
}
