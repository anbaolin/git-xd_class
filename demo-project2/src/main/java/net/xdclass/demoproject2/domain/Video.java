package net.xdclass.demoproject2.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Video implements Serializable {

    private  int  id;
    private  String  title;
  //  @JsonInclude(JsonInclude.Include.NON_NULL)  //空字段不返回
    private  String  summary;
    private  int   price;

     @JsonProperty("cover_img")//指定别名
    @JsonInclude(JsonInclude.Include.NON_NULL)   //空字段不返回：
    private  String  coverImg;

    @JsonProperty("create_time")  //指定别名
    @JsonFormat(pattern="yyyy-MM-ddhh:mm:ss",locale="zh",timezone="GMT+8")  //指定⽇期格式
    private Date createTime;
    private List<Chapter>  chapterList;  //视频里的章节，


    //无参构造方法
    public Video() {
        super();
    }

    //有参构造方法
    public  Video(int id,String title){
        this.id = id;
        this.title = title;
        this.createTime = new Date();
    }





    public List<Chapter> getChapterList() {
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        this.chapterList = chapterList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }



    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                ", chapterList=" + chapterList +
                '}';
    }
}



