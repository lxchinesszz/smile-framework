package org.smile.framework.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smile.framework.ioc.annotation.AutoInsert;
import org.smile.framework.ioc.annotation.Bean;
import org.smile.framework.ioc.annotation.Component;
import org.smile.framework.util.ClassUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Package: org.smile.framework.ioc
 * @Description: ${todo}
 * @author: liuxin
 * @date: 17/4/5 下午6:02
 */
public class BeanHelper {
    private final static Logger logger= LoggerFactory.getLogger(BeanHelper.class);
    /**
     * Bean Map（Bean 类 => Bean 实例）
     */
    private static final Map<Class<?>, Object> beanMap = new HashMap<Class<?>, Object>();

    static {
        try {
            //根据包名加载所有的class，可以根据配置文件去定义
            Set<Class<?>> classSet = ClassUtil.getClassSet("");
            for (Class cls : classSet) {//如果包含了这些注解，就加载
                if (cls.isAnnotationPresent(AutoInsert.class) || cls.isAnnotationPresent(Bean.class) || cls.isAnnotationPresent(Component.class)) {
                    Object obj = cls.newInstance();
                    beanMap.put(cls,obj);
                }
            }
        }catch (Exception e){
            logger.error("IOC加载bean错误：{}",e.getMessage());
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取 Bean Map
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return beanMap;
    }

    /**
     * 获取 Bean 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls) {
        if (!beanMap.containsKey(cls)) {
            throw new RuntimeException("无法根据类名获取实例！" + cls);
        }
        return (T) beanMap.get(cls);
    }

    /**
     * 设置 Bean 实例
     */
    public static void setBean(Class<?> cls, Object obj) {
        beanMap.put(cls, obj);
    }

}
