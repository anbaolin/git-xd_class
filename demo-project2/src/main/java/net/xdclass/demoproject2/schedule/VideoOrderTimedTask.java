package net.xdclass.demoproject2.schedule;

/*
         fixedRate: 定时多久执⾏⼀次（上⼀次开始执⾏时间点后xx秒再次执⾏；）
         fixedDelay: 上⼀次执⾏结束时间点后xx秒再次执⾏
         cron 定时任务表达式
*/

//定时任务业务类
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VideoOrderTimedTask {

        // @Scheduled(fixedDelay =4000)   // fixedDelay: 上⼀次执⾏结束时间后,6秒后再次执⾏
       //@Scheduled(fixedRate =2000)//每两秒执行一次,  定时多久执⾏⼀次（上⼀次开始执⾏时间点后xx秒再次执⾏；）
       //@Scheduled(cron ="*/1 * * * * *")//每秒执行一次
       public  void  sun(){
             //定时统计交易额，这是模拟，正常从数据库中查询
             System.out.println(LocalDateTime.now()+"当前交易额"+Math.random());


           try {
               Thread.sleep(2000L);  //用线程测试间隔
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
}
