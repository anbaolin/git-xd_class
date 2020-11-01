package net.xdclass.demoproject2.domain;
//视频章节 ，章里面有集，没定义"集"实体类  和没在这里定义集的list集合属性
public class Chapter {

       private  int  id;
       private  int  videoId;
       private  String  title;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                '}';
    }
}
