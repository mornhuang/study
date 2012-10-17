package com.huang.study.base;

import java.lang.reflect.ParameterizedType;

public class BaseModel<T> {
	private Class<T> entityClass;

	/** Model类默认Class对象名，不包括包路径 */
	private String entityClassName;

	@SuppressWarnings("unchecked")
	public BaseModel() {
		if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
			System.out.println(((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
			entityClass = (Class<T>) ((ParameterizedType) getClass()
					.getGenericSuperclass()).getActualTypeArguments()[0];
			entityClassName = entityClass.getSimpleName();
		}
	}
}
