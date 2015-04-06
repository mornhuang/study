package com.huang.j2ee.ch00.service;


import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * Created By User : Morn
 * Created DateTime: 2015/3/5 16:39
 * Descriptions    : 测试BeanFactoryPostProcessor,熟悉Bean初始化流程
 */
public class BeanCounter implements BeanFactoryPostProcessor {
    private Logger logger = Logger.getLogger(BeanCounter.class.getName());

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        logger.debug("Bean Count: " + beanFactory.getBeanDefinitionCount());
    }
}
