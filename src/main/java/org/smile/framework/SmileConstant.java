package org.smile.framework;

import org.smile.framework.core.ConfigHelper;

/**
 * @Package: org.smile.framework
 * @Description: 框架中，固定的常量属性，主要读取配置文件中定义的信息
 * @author: liuxin
 * @date: 17/4/10 上午9:22
 */
public interface  SmileConstant {
    //默认的配置文件名称
    String CONFIG_PROPS = "smile.properties";
    String SQL_PROPS = "smile-sql.properties";
    String PLUGIN_PACKAGE = "org.smile4j.plugin";
    String VIEW_PATH= ConfigHelper.getString("smile.framework.app.view_path","/WEB-INF/view/");
    String HOME_PAGE=ConfigHelper.getString("smile.framework.app.view_page","/index.html");
    String BASE_PACKAGE="";
}
