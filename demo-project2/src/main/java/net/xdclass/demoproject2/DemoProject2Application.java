package net.xdclass.demoproject2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication  /*标记这是springboot应用,里面包含多个注解*/
@ServletComponentScan  //Servlet3.0的注解进⾏配置⾃定义的过滤器,启动类⾥⾯增加 @ServletComponentScan，进⾏扫描
@EnableScheduling     //定时任务注解
@EnableAsync    // 启动类⾥⾯使⽤@EnableAsync注解开启功能,⾃动扫描 ......异步任务
public class DemoProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoProject2Application.class, args);
	}

}
