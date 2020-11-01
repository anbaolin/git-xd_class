package net.xdclass.demoproject2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demoproject2.domain.Video;
import net.xdclass.demoproject2.service.VideoService;
import net.xdclass.demoproject2.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/*
 视频控制器

 /*  //把整个JSON对象转成字符串 序列化
             ObjectMapper  objectMapper = new ObjectMapper();
                    String  jsonstr =  objectMapper.writeValueAsString(list);
                   System.out.println(jsonstr);

                List<Video> video =  objectMapper.readValue(jsonstr,List.class);//反序列化*/

@RestController     //：⽤于标记这个类是⼀个控制器，返回JSON数据的时候使⽤
@RequestMapping("/api/v1/pub/video")
public class VideoController {

//给前端提供一个视频列表接口
    @Autowired
    private VideoService   videoService;

       // @RequestMapping(value ="list",method =RequestMethod.GET)
         @GetMapping("list")  // 用这种就行 代表了上面的 get请求
         public  JsonData  list() throws JsonProcessingException {

             List<Video>   list = videoService.listVideo();

               return JsonData.buildSuccess(list);  //带统⼀接⼝返回协议
         }




    /*实战RequestBody对象数组提交接⼝开发
        新增视频json对象，章数组提交,,,,POST请求里,因为我们都是以json格式提交数据的，
        这时候我们要加一个注解@RequestBody*/
         @PostMapping("save_video_chapter")
         public  JsonData  saveVideoChapter(@RequestBody Video video){
                System.out.println(video.toString());//打印一下
               return  JsonData.buildSuccess("");
         }

}
