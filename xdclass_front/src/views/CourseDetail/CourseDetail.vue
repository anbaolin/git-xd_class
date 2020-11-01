<template>
  <!-- 开发视频详情页面 -->

  <div>
    <!-- 视频详情页面顶部的组件 -->
    <detail-header :videoInfo="videoInfo"></detail-header>

    <!-- 视频介绍组件 -->
    <detail-course :videoInfo="videoInfo"></detail-course>

    <!-- 视频tab简介组件,包含章 集-->
    <detail-tab :videoInfo="videoInfo" :chapterList="chapterList"></detail-tab>

    <!-- 底部的立刻购买组件-->
    
 <!-- 跳转到哪个路径+路由的id,就是视频详情页面带着的那个(根据id查询视频详情页面，就是这个id) 
               路径/pay是router文件夹里的pay    this.$route.query.video_id  获取到这个id  -->
        <footer>
            <router-link :to="{path:'/pay',query:{video_id:this.$route.query.video_id}}" class="user_buy">
                <button>立刻购买</button>            
            </router-link>
        </footer> 

  </div>
</template>



<script>
//导入组件,先导入这几个模块，其他的两个模块是在Tab里面的
import DetailHeader from "./Components/Header";
import DetailCourse from "./Components/Course";
import DetailTab from "./Components/Tab";
import {getVideoDetail } from "@/api/getData.js"; // //按需导入:导入api里的getVideoDetail视频详情接口，

export default {
  //注册组件，也叫声明组件
  components: {
    DetailHeader,
    DetailCourse,
    DetailTab,
  },

  //数据源
  data() {
    return {
      //获得视频详情信息
      videoInfo: {},
      //获得视频的章集
      chapterList: [],
    };
  },

  //  async ⽤于声明⼀个 function 是异步的
  //   await ⽤于等待⼀个异步⽅法执⾏完成（发起请求，查询数据库、发起http等）
  //   getBannerData：方法名，这个方法是异步的  ,获取轮播图
  //方法体里都要加 await ,声明方法都要加async

  //定义方法
  methods: {
    //获取视频详情
    async getDetail(vid) {

      try {
        //api文件夹里的getData方法,拿到它里面的视频详情数据，上面已经导入api
        const result = await getVideoDetail(vid);

        //console.log(result);

        //如果数据的状态码=0,就拿到数据
        if (result.data.code === 0) {
          //付给上面的  videoInfo
          this.videoInfo = result.data.data;
          //chapter_list:是后端的数据，赋值给chapterList
          this.chapterList = result.data.data.chapter_list;
        }
      } catch (error) {
        console.lo(error);
      }
    }
  },

  //定义vue实例生命周期,：⻚⾯渲染完成后,调⽤⽅法获取数据
  mounted() {
    //console.log(this.$route.query.video_id); //打印 id
    this.getDetail(this.$route.query.video_id);
  }
};
</script>





<style lang="scss" scoped>
//底部
footer {
  // fixed固定在底部
  position: fixed;
  bottom: 0;
  width: 100%;
  padding: 8px 0;
  background-color: #fff;
  z-index: 999;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
}
//设置购买按钮样式
button {
  display: block;
  color: #fff;
  margin: 0 auto;
  background-color: #d93f30;
  height: 34px;
  line-height: 34px;
  border-radius: 17px;
  width: 80%;
  border: none;
  font-size: 15px;
  text-align: center;
}
</style>
 
