package org.smile.framework.ioc;

import org.smile.framework.core.fault.InitError;
import org.smile.framework.ioc.annotation.AutoInsert;
import org.smile.framework.util.ArraysUtil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

/**
 * @Package: org.smile.framework.ioc
 * @Description: 注入所有依赖
 * @author: liuxin
 * @date: 17/4/5 下午6:02
 */
public class IocHelper {
    static {
        try {
            Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();//bean的类型
                Object beanInstance = beanEntry.getValue();//bean的实例对象
                Field[] fields = beanClass.getDeclaredFields();//获得bean的依赖
                if (ArraysUtil.isNotEmpty(fields)) {
                    for (Field beanField : fields) {
                        if (beanField.isAnnotationPresent(AutoInsert.class)) {
                            Class<?> interfaceClass = beanField.getType();//获得类型
                            Object implementClass = BeanHelper.getBean(interfaceClass);//根据类型获得实例
                            beanField.setAccessible(true);
                            beanField.set(beanInstance,implementClass);//注入
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new InitError("IOC容器初始化失败",e);
        }
    }
}
