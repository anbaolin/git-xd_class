package net.xdclass.demoproject2.service.impl;

import net.xdclass.demoproject2.domain.User;
import net.xdclass.demoproject2.mapper.UserMapper;
import net.xdclass.demoproject2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

//用户service实现类
@Service
public class UserServiceImpl implements UserService {

   public   static Map<String,User> sessionMap = new HashMap<>();

    @Autowired
    private UserMapper  userMapper;



   //返回一个测试id
    @Override
    public String login(String username, String pwd) {

            User user = userMapper.login(username,pwd);
            if(user==null){
                return null;
            }else{
                String  token   =  UUID.randomUUID().toString();
                System.out.println(token);
                sessionMap.put(token,user);//将密码和user对象存入map里，相当于存入数据库，我们这边是因为测试才这样写
                return token;
            }


    }

       /*
        list接口，显示全部用户信息
        */

    @Override
    public List<User> listUser() {

        return  userMapper.listUser();

    }
}
