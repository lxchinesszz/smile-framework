package org.smile.framework.util;

import com.sun.deploy.util.StringUtils;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * @Package: org.smile.framework.util
 * @Description: 加载类
 * @author: liuxin
 * @date: 17/4/5 下午5:16
 */
public class ClassUtil {
    private final static Logger logger= LoggerFactory.getLogger(ClassUtil.class);
    /**
     * 获取类加载器
     *
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     *
     * @param className
     * @param isInit
     * @return
     */
    public static Class<?> loadClass(String className, boolean isInit) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInit, getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return cls;

    }

    /**
     * 获取指定包下面的所有类
     *
     * @param packageName
     * @return
     */
    public static Set<Class<?>> getClassSet(String packageName) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(packageName.replace(".", "/"));
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url != null) {
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")) {
                        String packagePath =null;
                        try {
                            packagePath= new String(URLCodec.decodeUrl(url.getPath().getBytes()));
                        }catch (DecoderException de){
                            logger.error("加载class字节码,中文解析错误");
                            throw new RuntimeException(de);
                        }
                        addClass(classSet, packagePath, packageName);
                    }
                }
            }
        } catch (IOException ie) {
            throw new RuntimeException(ie);
        }
        return classSet;
    }

    private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName) {
        File[] files = new File(packagePath).listFiles(new FileFilter() {
            //如果是目录或者是.class后文件就true
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
        for (File file : files) {
            String fileName = file.getName();
            if (file.isFile()) {
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if (StringUtil.isEmpty(packageName)) {
                    className = packageName + "." + className;
                }
                doAddClass(classSet, className);
            } else {
                String subPackagePath = fileName;
                if (StringUtil.isEmpty(packagePath)) {
                    subPackagePath = packagePath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if (StringUtil.isEmpty(packageName)) {
                    subPackageName = packageName + "." + subPackageName;
                }
                addClass(classSet, subPackagePath, subPackageName);
            }
        }
    }

    private static void doAddClass(Set<Class<?>> classSet, String className) {
        Class<?> cls = loadClass(className, false);
        classSet.add(cls);
    }
}
