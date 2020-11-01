package net.xdclass.demoproject2.controller;

import net.xdclass.demoproject2.domain.User;
import net.xdclass.demoproject2.service.UserService;
import net.xdclass.demoproject2.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
讲解springboot接⼝，http的POST请求
        POST请求-form表单
        场景：表单提交，如果不⽤细分PUT/DELETE⽅法，则都可以⽤POST
        注解：@PostMapping = @RequestMapping(method = RequestMethod.POST)
开发功能：账号密码提交登录接⼝，form表单形式
*/

//post请求
@RestController
@RequestMapping("/api/v1/pub/user")
public class UserController {

          @Autowired
          private UserService   userService;

   /*
     登录接口
    */
  //提交表单参数特别多时候,因为我们都是以json格式提交数据的，这时候我们要加一个注解@RequestBody
    @PostMapping("login")
    public JsonData  login(@RequestBody User user){
        //打印测试提交表单
        System.out.println("user"+user.toString());
            String  token = userService.login(user.getUsername(),user.getPwd());
             if(token!=null)
                 return JsonData.buildSuccess(token);
              if(token==null)
                  return JsonData.buildError("账号密码错误");
        return  null;
    }



     /*
       列出全部用户信息

        SpringBoot2.X⾥⾯定制JSON字段
        jackson处理相关⾃动
        指定字段不返回：@JsonIgnore
        指定⽇期格式：@JsonFormat(pattern="yyyy-MM-dd
        hh:mm:ss",locale="zh",timezone="GMT+8")
        空字段不返回：@JsonInclude(Include.NON_NULL)
        指定别名：@JsonProperty
        开发功能：视频创建时间返回⾃定义格式；过滤⽤户敏感信息
        序列化和反序列化操作
      */

      @GetMapping("list_User")
      public  JsonData  listUser(){
          List<User>   list =userService.listUser();

           return JsonData.buildSuccess(list);
      }


}
