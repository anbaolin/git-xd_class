package net.xdclass.demoproject2.service.impl;

import net.xdclass.demoproject2.domain.Video;
import net.xdclass.demoproject2.mapper.VideoMapper;
import net.xdclass.demoproject2.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {


      @Autowired
      private VideoMapper   videoMapper;




    @Override
    public List<Video> listVideo() {
        return   videoMapper.listVideo();

    }


}
