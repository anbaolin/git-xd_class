package net.xdclass.demoproject2.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 请求监听器
 * ServletRequestListener 请求监听
 * 常⽤的监听器 ServletContextListener、HttpSessionListener、ServletRequestListener)
 */
@WebListener
public class CustomRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("requestDestroyed=======销毁请求监听器");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("requestDestroyed=======启动请求监听器");
    }
}
