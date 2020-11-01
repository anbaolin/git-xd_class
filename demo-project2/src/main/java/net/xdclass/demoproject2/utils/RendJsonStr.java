package net.xdclass.demoproject2.utils;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;

//工具类 ，自动关闭IO流  ，拿到输出流,把内容输出
public class RendJsonStr {

    /*
      这个工具类可以用在过滤器或者是拦截器写法中
     */
       public static  void  renderJson(ServletResponse response, String json){

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");   //内容类型
        try(PrintWriter writer = response.getWriter()){
                writer.print(json);//出去了
        } catch (Exception e) {   //捕获异常
            e.printStackTrace();
        }
    }
}
