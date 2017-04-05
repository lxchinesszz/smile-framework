package org.smile.framework.util;

/**
 * @Package: org.smile.framework.util
 * @Description: 字符串工具类
 * @author: liuxin
 * @date: 17/4/5 下午5:22
 */
public class StringUtil {
    public static boolean isEmpty(String content){
        return content!=null?true:false;
    }

    public static boolean isNotEmpty(String content){
        return content!=null?false:true;
    }

}
