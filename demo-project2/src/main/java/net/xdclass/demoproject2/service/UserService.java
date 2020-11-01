package net.xdclass.demoproject2.service;

import net.xdclass.demoproject2.domain.User;

import java.util.List;

//用户service接口
public interface UserService {

  /*
   登录接口
   */
   public String  login(String username, String pwd);




       /*
        list接口，显示全部用户信息
        */

       public List<User>  listUser();
}
