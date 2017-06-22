package org.smile.framework.util;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @Package: org.smile.framework.util
 * @Description: 读取配置
 * @author: liuxin
 * @date: 17/4/10 上午9:26
 */
public class PropsUtil {
    private final static Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loads(String configPath) {
        Properties properties = null;
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(configPath);
        try {
            properties.load(is);
        } catch (IOException ioe) {
            logger.error("读取配置新建出错");
            throw new RuntimeException(ioe);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ioe) {
                    logger.error("文件流关闭异常");
                    throw new RuntimeException(ioe);
                }

            }
        }
        return properties;
    }

    /**
     * propertis的keySet继承Hashtable<Object, Object>键值声明类型只能用Object
     *
     * @param configPath
     * @return
     */
    public static Map<String, String> loadToMap(String configPath) {
        Properties properties = loads(configPath);
        Map<String, String> map = null;
        map = new HashMap<String, String>();
        Set<Object> keys = properties.keySet();
        for (Object key : keys) {
            map.put((String) key, (String) properties.get(key));
        }
        return map;
    }

    /**
     * 如果没有包含这个值，就返回空字符串
     *
     * @param properties
     * @param key
     * @return
     */
    public static String getString(Properties properties, String key) {
        String value = "";
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    /**
     * 如果没有包含这个值就返回，默认值
     *
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties.containsKey(key)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    public static Integer getNumber(Properties properties, String key) {
        Integer value = -1;
        if (properties.containsKey(key)) {
            value = Integer.valueOf(properties.getProperty(key));
        }
        return value;
    }

    /**
     * 如果不包含就返回默认
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static Integer getNumber(Properties properties, String key,Integer defaultValue) {
        Integer value = defaultValue;
        if (properties.containsKey(key)) {
            value = Integer.valueOf(properties.getProperty(key));
        }
        return value;
    }


    public static boolean getBoolean(Properties properties, String key) {
        boolean value =false;
        if (properties.containsKey(key)) {
            value = Boolean.valueOf(properties.getProperty(key));
        }
        return value;
    }

    /**
     * 如果不包含就返回默认
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static boolean getBoolean(Properties properties, String key,boolean defaultValue) {
        boolean value = defaultValue;
        if (properties.containsKey(key)) {
            value = Boolean.valueOf(properties.getProperty(key));
        }
        return value;
    }

    /**
     * 获取指定前缀的相关属性
     */
    public static Map<String, Object> getMap(Properties props, String prefix) {
        Map<String, Object> kvMap = new LinkedHashMap<String, Object>();
        Set<Object> keySet = props.keySet();
        if (CollectionUtils.isNotEmpty(keySet)) {
            for (Object key : keySet) {
                if (String.valueOf(key).startsWith(prefix)) {
                    String value = props.getProperty(String.valueOf(key));
                    kvMap.put(String.valueOf(key), value);
                }
            }
        }
        return kvMap;
    }
}
