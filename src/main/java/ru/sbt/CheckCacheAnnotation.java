package ru.sbt;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import ru.sbt.cacheproxy.CacheProxy;

import java.util.stream.Stream;

@Service
public class CheckCacheAnnotation implements BeanPostProcessor {
    private final CacheProxy proxy;

    public CheckCacheAnnotation() {
//        System.out.println("Start CheckCacheAnnotation");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        proxy = (CacheProxy) context.getBean("cacheProxy");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName);
//        bean.getClass().getDeclaredMethods();
//        Stream.of(bean.getClass().getDeclaredMethods())
//                .filter(m -> m.isAnnotationPresent())

        Class cazz = bean.getClass();
        return proxy.cache((clazz) bean);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}