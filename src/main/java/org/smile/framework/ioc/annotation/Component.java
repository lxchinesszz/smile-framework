package org.smile.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: org.smile.framework.ioc.annotation
 * @Description: 将组件添加到IOC容器
 * @author: liuxin
 * @date: 17/4/5 下午5:58
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
}
