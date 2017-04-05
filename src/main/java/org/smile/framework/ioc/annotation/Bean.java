package org.smile.framework.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Package: org.smile.framework.ioc.annotation
 * @Description: 标记需要被容器加载的class，主要用来配置类
 * @author: liuxin
 * @date: 17/4/5 下午6:01
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {
}
