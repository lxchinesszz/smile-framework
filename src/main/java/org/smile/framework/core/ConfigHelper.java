package org.smile.framework.core;

import org.smile.framework.SmileConstant;
import org.smile.framework.util.PropsUtil;

import java.util.Map;
import java.util.Properties;

/**
 * @Package: org.smile.framework.core
 * @Description: 包装配置读取类
 * @author: liuxin
 * @date: 17/4/10 上午10:05
 */
public class ConfigHelper {
    private static final Properties props= PropsUtil.loads(SmileConstant.CONFIG_PROPS);

    public static String getString(String key){
        return PropsUtil.getString(props,key);
    }

    public static String getString(String key,String defaultValue){
        return PropsUtil.getString(props,key,defaultValue);
    }

    public static Integer getInt(String key){
        return PropsUtil.getNumber(props,key);
    }
    public static Integer getInt(String key,Integer defalutValue){
        return PropsUtil.getNumber(props,key,defalutValue);
    }

    public static boolean getBoolean(String key){
        return PropsUtil.getBoolean(props,key);
    }

    public static boolean getBoolean(String key,boolean defaultValue){
        return PropsUtil.getBoolean(props,key,defaultValue);
    }

    public static Map<String,Object>getMap(String prefix){
        return PropsUtil.getMap(props,prefix);
    }
}
