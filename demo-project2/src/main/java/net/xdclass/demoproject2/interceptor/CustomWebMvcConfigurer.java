package net.xdclass.demoproject2.interceptor;

import com.sun.xml.internal.ws.wsdl.writer.W3CAddressingMetadataWSDLGeneratorExtension;
import org.aopalliance.intercept.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
   新版SpringBoot2.X拦截器配置实战
        简介: 讲解Spingboot2.x新版本配置拦截器在项⽬中的使⽤
        拦截器： 和过滤器⽤途基本类似
        SpringBoot2.x使⽤步骤
        SpringBoot2.X 新版本配置拦截器 implements WebMvcConfigurer

        ⾃定义拦截器 HandlerInterceptor
        preHandle：调⽤Controller某个⽅法之前
        postHandle：Controller之后调⽤，视图渲染之前，如果控制器Controller出现了
        异常，则不会执⾏此⽅法
        afterCompletion：不管有没有异常，这个afterCompletion都会被调⽤，⽤于资
        源清理
        按照注册顺序进⾏拦截，先注册，先被拦截   */

/*
 拦截器配置类

  先注册，先拦截，意思就是先添加的拦截器,先拦截，最先加载的after,最先出去
 */
@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                //addPathPatterns()配置拦截器路径，将拦截器和拦截路径添加进来
               registry.addInterceptor(getLoginInterCeptor()).addPathPatterns("/api/v1/pri/**");

               //可以添加多个拦截器，看需求......


              WebMvcConfigurer.super.addInterceptors(registry);//把参数传进来
    }


    /*
      获取到自定义的拦截器
     */
    @Bean
     public  LoginInterCeptor   getLoginInterCeptor(){


        return  new LoginInterCeptor();
     }


}
