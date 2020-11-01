package net.xdclass.demoproject2.Filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demoproject2.domain.User;
import net.xdclass.demoproject2.service.impl.UserServiceImpl;
import net.xdclass.demoproject2.utils.JsonData;
import net.xdclass.demoproject2.utils.RendJsonStr;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*使⽤新版Servlet3.0的注解开发⾃定义Filter过滤器

        简介：使⽤Servlet3.0注解开发⾃定义的过滤器
        使⽤Servlet3.0的注解进⾏配置步骤
        启动类⾥⾯增加 @ServletComponentScan，进⾏扫描
        新建⼀个Filter类，implements Filter，并实现对应的接⼝
@WebFilter 标记⼀个类为filter，被spring进⾏扫描
        urlPatterns：拦截规则，⽀持正则
        控制chain.doFilter的⽅法的调⽤，来实现是否通过放⾏
        不放⾏，web应⽤resp.sendRedirect("index.html") 或者 返回json字符串
        场景：权限控制、⽤户登录状态控制，也可以交给拦截器处理等
        在线教育项⽬案例实战:
        ⽤户登录过滤器*/


//@WebFilter(value = "/api/v1/pri/*",filterName ="loginFilter")   // 标记⼀个类为filter过滤器，被spring进⾏扫描
public class LoginFilter  implements Filter{
     //这个是将Json对象，转成KeyValue形式
      private  static  final ObjectMapper   objectMapper  = new ObjectMapper();
    /**
     * 容器加载时候
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
            System.out.println("init LoginFilter启动过滤器===========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter LoginFilter==============");
        HttpServletRequest  req  =(HttpServletRequest)servletRequest;
        HttpServletResponse   resp =(HttpServletResponse)servletResponse;
                  String  token   = req.getHeader("token");
                  if(StringUtils.isEmpty(token)){  //如果token为空串或者为null,它都是一个empty
                         token =  req.getParameter("token"); //就从请求参数里拿
                  }

            /* ⾃定义Filter 告诉APP.或者网页，用户未登录，或者登录过期 ,json错误码提示开发
               使⽤Servlet3.0注解开发⾃定义的过滤器，返回未登录错误码*/
                  if(!StringUtils.isEmpty(token)){   //如果不为Null
                      //判断是否合法
                      User   user = UserServiceImpl.sessionMap.get(token);  //从数据库Map里拿然后比较，符合
                      if(user!=null){  //拿到的token也可能失效了，
                          filterChain.doFilter(servletRequest,servletResponse);//传进来，符合需求的，下边是可能拿到的失效了
                      }else{  //否则拿到的token失效了

                          JsonData   jsonData =JsonData.buildErrorr(-2,"登录失败,token无效");
                         String  jsonStr =   objectMapper.writeValueAsString(jsonData); //这个是将Json对象，转成KeyValue形式字符串
                          RendJsonStr.renderJson(resp,jsonStr); // 输出response和json.  使用了流工具类 RendJsonStr
                      }

                  }else{  //走这个else 是因为token可能就没有
                      JsonData   jsonData =JsonData.buildErrorr(-3,"未登录");
                      String  jsonStr =   objectMapper.writeValueAsString(jsonData);
                      RendJsonStr.renderJson(resp,jsonStr);
                  }
           }




    /**
     * 容器销毁时候
     */
    @Override
    public void destroy() {
        System.out.println(" destroyFilter销毁过滤器===============");
    }
}
