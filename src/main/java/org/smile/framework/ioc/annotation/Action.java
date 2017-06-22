package org.smile.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: org.smile.framework.ioc.annotation
 * @Description: 动作方法，添加在方法上
 * @author: liuxin
 * @date: 17/4/10 上午10:18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {
    String value();
}
