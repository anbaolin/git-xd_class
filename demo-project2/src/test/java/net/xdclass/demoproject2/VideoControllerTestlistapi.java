package net.xdclass.demoproject2;

/*讲解Springboot的MockMvc调⽤api层接⼝
        如何测试Controller对外提供的接⼝
        增加类注解 @AutoConfigureMockMvc
注⼊⼀个MockMvc类
        相关API ：
        perform执⾏⼀个RequestBuilder请求
        andExpect：添加ResultMatcher->MockMvcResultMatchers验证规则
        andReturn：最后返回相应的MvcResult->Response
        案例：在线教育VideoController 视频列表接⼝ 单元测试*/

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;

@RunWith(SpringRunner.class)
@SpringBootTest(classes ={DemoProject2Application.class} )
@AutoConfigureMockMvc     ///多了一个注解
public class VideoControllerTestlistapi {
    // 在线教育VideoController 视频列表接⼝ 单元测试*/
          @Autowired
         private MockMvc   mockMvc;

          @Test
          public  void  testVideoListApi() throws  Exception{
                 //测试其他Api接口，改一下http请求地址，就行了，逻辑基本用改
                                         //MockMvcRequestBuiders构建http请求
           MvcResult  mvcResult  =  mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/pub/video/list"))
                 //预期                                         //andReturn返回
               .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();//isok：是否是http200响应码

                    int  status  =  mvcResult.getResponse().getStatus();
                     System.out.println(status);//状态码200
                     //这相当于一个串了,后面指定编码格式
                   String   result   =    mvcResult.getResponse().getContentAsString(Charset.forName("UTF-8"));
                   System.out.println(result);

          }
}


