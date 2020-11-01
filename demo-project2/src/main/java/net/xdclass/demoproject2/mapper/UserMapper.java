package net.xdclass.demoproject2.mapper;

import net.xdclass.demoproject2.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//用户dao
@Repository
public class UserMapper {

    private  static Map<String,User> userMap = new HashMap<>();

    static{
        userMap.put("jack",new User(1,"jack","123456"));
        userMap.put("xdclas-lw",new User(2,"xdclas-lw","1234"));
        userMap.put("tom",new User(3,"tom","123456789"));
    }





      //登录语句
       public  User  login(String username,String pwd){

            User  user =  userMap.get(username);
            //如果user=空
            if(user==null){
                return  null; //返回一个空
            }
            if(user.getPwd()==null){  //判断密码是否为空
                return null;
            }
            if(user.getPwd().equals(pwd)){ //判断数据库的密码和用户传入的密码如果一致，则返回user对象
                return  user;
            }
             return null;
       }



       /*
        list接口，显示全部用户信息
        */
        public List<User>  listUser(){
               List<User> list = new ArrayList<>();
                  list.addAll(userMap.values());
            return  list;
        }
}
