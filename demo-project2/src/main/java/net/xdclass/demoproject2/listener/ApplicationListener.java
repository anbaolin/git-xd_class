package net.xdclass.demoproject2.listener;
/*
  Servlet3.0+SpringBoot2.X 注解Listener常⽤监听器
        作⽤
        ServletContextListener 应⽤启动监听
        HttpSessionLisener 会话监听
        ServletRequestListener 请求监听
        常⽤的监听器 ServletContextListener、HttpSessionListener、ServletRequestListener)*/

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *  springBOOT2.x新版上下文监听器
 * 应用上下文监听器
 */
@WebListener
public class ApplicationListener  implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
           System.out.println("contextInitialized应用启动监听==============");  //启动监听器
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed销毁应用监听==============");  //销毁监听器
    }
}
