package com.huang.web.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring bean容器
 * @description spring bean容器
 * @time Mar 13, 2009 3:44:27 PM create
 * @version 1.0
 */
public class BeanContainer implements ApplicationContextAware
{
	/** spring上下文对象 */
	private static ApplicationContext context;

	/**
	 * 根据spring配置的BeanID获取Bean对象
	 * @param beanName spring配置的BeanID
	 * @return 返回Bean对象
	 */
	public static Object getBean(String beanName)
	{
		return context.getBean(beanName);
	}

	/**
	 * 获取上下文对象
	 * @return 返回上下文对象
	 */
	public static ApplicationContext getInstance()
	{
		return context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@SuppressWarnings("static-access")
	public synchronized void setApplicationContext(ApplicationContext contextIn) throws BeansException
	{
		if (null == this.context)
		{
			this.context = contextIn;
		}
	}

}
