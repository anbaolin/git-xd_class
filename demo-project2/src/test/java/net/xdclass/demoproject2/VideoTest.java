package net.xdclass.demoproject2;

import junit.framework.TestCase;
import net.xdclass.demoproject2.DemoProject2Application;
import net.xdclass.demoproject2.domain.Video;
import net.xdclass.demoproject2.service.VideoService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes ={DemoProject2Application.class})

public class VideoTest {

        @Autowired
         private VideoService   videoService;




             @Before
             public  void  testOne1(){
                 System.out.println("这个测试Before");
             }


             @Test     //service层单元测试
             public  void testVideoList(){
               List<Video>  videoList= videoService.listVideo();
               TestCase.assertTrue(videoList.size()>0);  //大于0
           }


              @After
              public  void  testAfter(){
               System.out.println("这个测试是after");
           }




}
