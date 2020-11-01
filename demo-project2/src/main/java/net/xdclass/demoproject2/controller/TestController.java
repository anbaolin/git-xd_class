package net.xdclass.demoproject2.controller;


import net.xdclass.demoproject2.config.WxConfig;
import net.xdclass.demoproject2.task.AsyncTask;
import net.xdclass.demoproject2.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
   /*  测试类
        新版SpringBoot注解配置⽂件映射属性和实体类实战
        简介：讲解使⽤@value注解,将配置⽂件⾃动映射到属性和实体类
        ⽅式⼀
1、Controller上⾯配置 @PropertySource({"classpath:resource.properties"})
2、增加属性 @Value("${test.name}") private String n
        */

@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})  //类路径下的properties配置文件
public class TestController {
 //${wxpay.appid}这个必须和配置文件properties文件里的配置名称一致，否则报错
      @Value("${wxpay.appid}")
      private  String   payAppid;
      @Value("${wxpay.sercret}")
      private   String  paySercret;

       @Autowired
       private WxConfig  wxConfig;  //自动引入  WxConfig微信配置文件，我们是拿这个配置文件的属性，而不是返回

       @Autowired
       private AsyncTask   asyncTask;  //将异步任务业务类注进来

     //获取微信配置文件信息
      @GetMapping("get_config")
      public JsonData  testConfig(){

          Map<String,String>  map = new HashMap<>();
             //这是直接通过注解方式
//            map.put("appid",payAppid);
//            map.put("secret",paySercret);

              //通过引入配置类，通过配置类获取
              map.put("appid",wxConfig.getPayAppid());
              map.put("secret",wxConfig.getPaySercret());
              map.put("mechid",wxConfig.getPaymechId());

          return  JsonData.buildSuccess(map);
      }





    //测试自定义的异常，SpringBoot2.x⾃定义全局异常返回⻚⾯  返回一个自定义异常的页面和json对象演示
    @GetMapping("list")
    public  JsonData tesExit(){
        //  int  i=1/0;
        return  JsonData.buildSuccess("");
    }


    /*SpringBoot2.x异步任务EnableAsync实战
     测试异步任务 响应时间*/
    @GetMapping("async")
    public  JsonData  testAsync(){
         long   begin   =  System.currentTimeMillis();//拿到开始时间
        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();
        long  end  =  System.currentTimeMillis(); //拿到结束时间
        return  JsonData.buildSuccess( end - begin); //响应耗时
    }


     /*⽤SpringBoot2.x开发异步任务Future获取结果
              定义异步任务类需要获取结果
      注意点：
      要把异步任务封装到类⾥⾯，不能直接写到Controller
      增加Future 返回结果 AsyncResult("task执⾏完成");
      如果需要拿到结果 需要判断全部的 task.isDone()*/

     @GetMapping("asyncs")
     public  JsonData  testAsync2(){
         long   begin   =  System.currentTimeMillis();//拿到开始时间
        Future<String> task4 = asyncTask.task4();  //返回一个Future
        Future<String> task5 = asyncTask.task5();
        for(;;){
            if(task4.isDone() && task5.isDone()){ //死循环判断task4和task5是否完成
                try {
                    /*
                     异步请求，并行、拿到结果取耗时时间大的那个，并发比串行执行效率高，
                     串行拿到结果后，还得等另一个结果，耗时比较长
                     并行
                     */

                    String task4Result = task4.get(); //拿到task4结果
                    System.out.println(task4Result);

                    String task5Result = task5.get();//拿到task5结果
                    System.out.println(task5Result);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }finally {
                    break;  //跳出循环
                }
            }
        }
         long  end  =  System.currentTimeMillis(); //拿到结束时间
         return  JsonData.buildSuccess( end - begin); //响应耗时
     }




}
