package org.cbol.framework.starter.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @author yaowenlei
 * @date 2023年11月26日 10:39 上午
 */
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        return CONTEXT.getBean(clazz);
    }

    public static  Object getBean(String beanName) {
        return CONTEXT.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        return CONTEXT.getBean(beanName, clazz);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        return CONTEXT.getBeansOfType(clazz);
    }

    public static ApplicationContext getInstance() {
        return CONTEXT;
    }
}
