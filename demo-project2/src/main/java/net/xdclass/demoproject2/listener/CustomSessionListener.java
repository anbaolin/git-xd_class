package net.xdclass.demoproject2.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 会话监听器
 */
@WebListener
public class CustomSessionListener implements HttpSessionListener{


    @Override
    public void sessionCreated(HttpSessionEvent se) {   //启动会话监听器
           System.out.println("sessionCreated=======启动会话监听器");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {  //销毁会话监听器
        System.out.println("sessionCreated=======销毁会话监听器");
    }
}
