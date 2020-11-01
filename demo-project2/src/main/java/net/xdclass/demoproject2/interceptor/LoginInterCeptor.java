package net.xdclass.demoproject2.interceptor;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demoproject2.domain.User;
import net.xdclass.demoproject2.service.impl.UserServiceImpl;
import net.xdclass.demoproject2.utils.JsonData;
import net.xdclass.demoproject2.utils.RendJsonStr;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的拦截器
 */
public class LoginInterCeptor implements HandlerInterceptor {

    //这个是将Json对象，转成KeyValue形式   序列化
    private  static  final ObjectMapper objectMapper  = new ObjectMapper();
        /*
        preHandle：调⽤Controller某个⽅法之前
        */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
           System.out.println("loginInterCeptor  preHandle拦截器==========");

                    String  token   =  request.getHeader("token");
                    if(StringUtils.isEmpty(token)){  //如果token为空串，或者为空,它都是一个empty
                             token =  request.getParameter(token);
                    }

            /* ⾃定义Filter 告诉APP.或者网页，用户未登录，或者登录过期 ,json错误码提示开发
               使⽤Servlet3.0注解开发⾃定义的过滤器，返回未登录错误码*/
                   if(!StringUtils.isEmpty(token)){  //如果不为空
                      User user   =    UserServiceImpl.sessionMap.get(token);//从map里拿，然后比较
                       if(user!=null){//用户不为空往下走返回true,但拿到的token也可能失效了,继续往下
                             return true; //往下走
                       }else{//否则拿到的token失效了
                         JsonData  jsonData =  JsonData.buildErrorr(-2,"登录失败,token无效");
                            String   jsonstr  =    objectMapper.writeValueAsString(jsonData); //序列化转到前端那里
                             RendJsonStr.renderJson(response,jsonstr);//关闭流，输出内容，使用了工具类
                             return false;
                           }

                   }else{//走这个else 是因为token可能就没有
                       JsonData  jsonData =  JsonData.buildErrorr(-3,"未登录");
                       String   jsonstr  =    objectMapper.writeValueAsString(jsonData);
                       RendJsonStr.renderJson(response,jsonstr);
                       return false;
                   }

        //return HandlerInterceptor.super.preHandle(request,response,handler);  //调用父类，将参数传进去
    }
















    /*  下边的postHandle 和afterCompletion可以不重写
     postHandle：Controller之后调⽤，视图渲染之前，如果控制器Controller出现了
     异常，则不会执⾏此⽅法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle  preHandle拦截器Controller之后调⽤，视图渲染之前==========");
        HandlerInterceptor.super.postHandle(request,response,handler,modelAndView);
    }

    /*
     afterCompletion：不管有没有异常，这个afterCompletion都会被调⽤，⽤于资源清理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("afterCompletion  preHandle不管有没有异常，这个afterCompletion都会被调⽤==========");
        HandlerInterceptor.super.afterCompletion(request,response,handler,ex);
    }
}
