package org.smile.framework.core;

import org.smile.framework.ioc.annotation.AutoInsert;
import org.smile.framework.ioc.annotation.Bean;
import org.smile.framework.ioc.annotation.Component;
import org.smile.framework.ioc.annotation.Service;
import org.smile.framework.util.ClassUtil;
import java.util.HashSet;
import java.util.Set;

/**
 * @Package: org.smile.framework.core
 * @Description:
 * @author: liuxin
 * @date: 17/4/10 上午10:21
 */
public final class ClassHelper {
    /**
     * 获取基础包名
     */
    private static final String BASEPACKAGE = ConfigHelper.getString("smile.framework.app.base_package");
    /**
     * 从此目录下获取字节码
     */
    private static final Set<Class<?>> CLASSSET = ClassUtil.getClassSet(BASEPACKAGE);

    /**
     * 获得所有被Service修饰的对象
     * @return
     */
    public static Set<Class<?>> getServicesClassSet() {
        Set<Class<?>> serviceClassSet = new HashSet<Class<?>>();
        for (Class cls : CLASSSET) {
            if (cls.isAnnotationPresent(Service.class)) {
                serviceClassSet.add(cls);
            }
        }
        return serviceClassSet;
    }

    /**
     * 获得所有Controller修饰的对象
     * @return
     */
    public static Set<Class<?>> getControllerClassSet(){
        Set<Class<?>> controllerClassSet = new HashSet<Class<?>>();
        for (Class cls : CLASSSET) {
            if (cls.isAnnotationPresent(Service.class)) {
                controllerClassSet.add(cls);
            }
        }
        return controllerClassSet;
    }

    /**
     * 获得所有Bean修饰的对象
     * @return
     */
    public static Set<Class<?>> getBeanClassSet(){
        Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
        for (Class cls : CLASSSET) {
            if (cls.isAnnotationPresent(Bean.class)) {
                beanClassSet.add(cls);
            }
        }
        return beanClassSet;
    }

    public static Set<Class<?>> getAutoInsertSet(){
        Set<Class<?>> autoInsertSet=new HashSet<Class<?>>();
        for (Class cls:CLASSSET){
            if (cls.isAnnotationPresent(AutoInsert.class)){
                autoInsertSet.add(cls);
            }
        }
        return autoInsertSet;
    }

    public static Set<Class<?>> getComponentSet(){
        Set<Class<?>> componentSet=new HashSet<Class<?>>();
        for (Class cls:CLASSSET){
            if (cls.isAnnotationPresent(Component.class)){
                componentSet.add(cls);
            }
        }
        return componentSet;
    }
}
