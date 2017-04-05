package org.smile.framework.util;

import org.junit.Test;

import java.util.Iterator;
import java.util.Set;

/**
 * @Package: org.smile.framework.util
 * @Description: 测试加载所有的字节码
 * @author: liuxin
 * @date: 17/4/5 下午5:37
 */
public class ClassUtilsTest {
    @Test
    public void testClassSet() {
        Set<Class<?>> classSet = ClassUtil.getClassSet("org.smile.framework.util");
        Iterator<Class<?>> it = classSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().getName());
        }
    }
}
