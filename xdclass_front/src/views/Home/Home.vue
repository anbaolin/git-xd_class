<template>
   <div>
   <!-- 首页轮播图 ,把data数据源里的数据banners，传给Banner.vue子组件，加了一个属性banners-->
  <home-banner :banners = "banners"></home-banner>

<!-- 视频列表 ,把data数据源里的数据videoList，传给Videolist.vue子组件，加了一个属性videoList-->
  <video-list :videoList = "videoList"></video-list> 
     
   
  <!-- 底部导航栏组件 -->
  <common-footer></common-footer>

  </div>
</template>



<script>
//导入组件
import HomeBanner from "./component/Banner"; //导入轮播图模块
import VideoList from "./component/VideoList"; //导入list数据列表模块
import CommonFooter from "@/components/CommonFooter"; //导入选项卡
import { getBanner, getVideoList } from"@/api/getData.js"; //按需导入:导入api里的getBanner：轮播图接口 和 getVideoList:视频列表接口，

export default {
  //注册组件，也叫声明组件
  components: {

    HomeBanner,
    VideoList,
    CommonFooter,
  },



  //数据源,获取VideoList和轮播图数据
  data() {
    return {
      //轮播图和视频列表是一个数组
      banners:[],
      videoList:[]
    }
  },


  //定义方法
  methods: {
    
     //获取轮播图数据
    async getBannerData() {

      try {
        //api文件夹里的getData方法,拿到它里面的轮播图数据，上面已经导入api,这里拿到轮播图列表数据
        const result = await getBanner();      
        //console.log(result); 
      
        //如果数据的状态码=0,就拿到数据
        if (result.data.code === 0) {
          //因为本身它包装了一层，所以 result.data.data，this.banners是赋值给上面数据源的banners数组
          this.banners = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },
         


      //   async ⽤于声明⼀个 function 是异步的
    //   await ⽤于等待⼀个异步⽅法执⾏完成（发起请求，查询数据库、发起http等）
    //   getBannerData：方法名，这个方法是异步的  ,获取轮播图
    //方法体里都要加 await ,声明方法都要加async



     //获取视频列表数据
      async getVList(){
         try{
         const result = await getVideoList();
            if (result.data.code == 0) {
             this.videoList = result.data.data;
           }
         }catch(error){
         console.log(error)
          }         
       }
    },

      mounted(){
          //定义vue实例生命周期,：⻚⾯渲染完成后,调⽤⽅法获取数据
            this.getBannerData();
            this.getVList()
      }
 };


</script>

<style lang="scss" scoped>
</style>