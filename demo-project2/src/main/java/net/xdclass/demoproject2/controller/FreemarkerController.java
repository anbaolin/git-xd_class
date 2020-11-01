package net.xdclass.demoproject2.controller;

import net.xdclass.demoproject2.config.WxConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  SpringBoot2.X整合模板引擎freemarker实战
    简介：SpringBoot2.x整合模板引擎freemarker和thymeleaf实战
 */
@Controller
@RequestMapping(value ="freemarker")
public class FreemarkerController {

          @Autowired   //引入微信配置文件，跳转到指定的页面，拿到配置文件信息
         private WxConfig   wxConfig ;


       @GetMapping("test")
       public  String  index(ModelMap  modelMap){

               modelMap.addAttribute("setting",wxConfig);

           //不用加后缀，因为配置文件里已经指定了后缀，跳转到指定的页面
           return "user/fm/index";
       }




    @GetMapping("thymeleaf")
    public  String  index2(ModelMap  modelMap){

        modelMap.addAttribute("setting",wxConfig);

        //不用加后缀，因为配置文件里已经指定了后缀，跳转到指定的页面
        return "tl/indexTwo";
    }
}
