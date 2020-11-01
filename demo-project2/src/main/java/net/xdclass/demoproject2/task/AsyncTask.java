package net.xdclass.demoproject2.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * 玩转SpringBoot2.x异步任务EnableAsync实战
 简介：什么是异步任务，和使⽤SpringBoot2.x开发异步任务实战
 什么是异步任务和使⽤场景：适⽤于处理log、发送邮件、短信……等
 下单接⼝->查库存 1000
 余额校验 1500
 ⻛控⽤户1000
 启动类⾥⾯使⽤ @EnableAsync 注解开启功能，⾃动扫描

 定义异步任务类并使⽤@Component标记组件被容器扫描,

 异步⽅法加上@Async
 */


//异步任务业务类
@Component
@Async//下边的方法都是异步的
public class AsyncTask {


      public  void    task1(){

            try {
                  Thread.sleep(4000L);//线程
            } catch (InterruptedException e) {
                  e.printStackTrace();
            }

            System.out.println("task1");
      }





      public  void    task2(){
            try {
                  Thread.sleep(4000L);//线程
            } catch (InterruptedException e) {
                  e.printStackTrace();
            }
            System.out.println("task2");
      }






      public  void    task3(){
             try {
                   Thread.sleep(4000L);//线程
             } catch (InterruptedException e) {
                   e.printStackTrace();
             }
            System.out.println("task3");
     }




     /*⽤SpringBoot2.x开发异步任务Future获取结果
              定义异步任务类需要获取结果
      注意点：
      要把异步任务封装到类⾥⾯，不能直接写到Controller
      增加Future 返回结果 AsyncResult("task执⾏完成");
      如果需要拿到结果 需要判断全部的 task.isDone()*/

   //以后调用远程接口，使用异步做,需要返回一定的类型，可以这样做，new 一个 AsyncResult<类型>告诉它返回一个类型
      //用什么类型接收
      //AsyncResult:用于包装异步任务的结果
      //Future:并发包
      public Future<String> task4(){
            try {
                  Thread.sleep(4000L);//线程
            } catch (InterruptedException e) {
                  e.printStackTrace();
            }
            System.out.println("task4");

            return  new AsyncResult<String>("任务4");  //声明返回一个类型
      }




      public Future<String>  task5(){
            try {
                  Thread.sleep(4000L);//线程
            } catch (InterruptedException e) {
                  e.printStackTrace();
            }
            System.out.println("task5");
            return new AsyncResult<String>("任务5");

      }
}
