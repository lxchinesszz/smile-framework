package org.smile.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: org.smile.framework.ioc.annotation
 * @Description: 控制层标记
 * @author: liuxin
 * @date: 17/4/10 上午10:28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
