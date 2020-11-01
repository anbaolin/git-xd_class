package net.xdclass.demoproject2.controller;

import net.xdclass.demoproject2.utils.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//使⽤Servlet3.0注解开发⾃定义的过滤器,使⽤新版Servlet3.0的注解开发⾃定义Filter
@RestController
@RequestMapping("/api/v1/pri/order")
public class VideoOrderController {


     //开发一个简单的订单接口，拦截
    @RequestMapping("save")
     public JsonData   saveOrder(){

          return JsonData.buildSuccess("下单成功");
     }
}
