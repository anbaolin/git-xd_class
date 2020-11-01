package net.xdclass.demoproject2;

import junit.framework.TestCase;
import net.xdclass.demoproject2.controller.UserController;
import net.xdclass.demoproject2.domain.User;
import net.xdclass.demoproject2.utils.JsonData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 用于用户的User模块的测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes ={DemoProject2Application.class} )
public class UserTest {

         @Autowired
         private UserController    userController;

          @Test
         public  void  loginTest(){

                User  user =  new User();
                      user.setUsername("jack");
                      user.setPwd("123456");
                JsonData jsonData  =   userController.login(user);  //JsonData必须序列化 ，to...String方法
                System.out.println(jsonData.toString());//获取到的用户信息是否正确
                TestCase.assertEquals(0,jsonData.getCode());//获取它的状态码，因为状态码是0，我们测试状态码是否是预期

              //断言失败。预期是0，实际是-1，我们就判断controller层是否正确，改了逻辑，我们跑关联测试时候，判断是否正确

         }
}
