package com.huang.j2ee.ssh.base;

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
			setEntityClassName(entityClass.getSimpleName());
		}
	}

	public String getEntityClassName() {
		return entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		this.entityClassName = entityClassName;
	}
}
