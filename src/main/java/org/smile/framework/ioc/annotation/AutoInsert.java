package org.smile.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: org.smile.framework.ioc.annotation
 * @Description: 用来标记需要IOC注入的对象
 * @author: liuxin
 * @date: 17/4/5 下午6:00
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoInsert {
}
