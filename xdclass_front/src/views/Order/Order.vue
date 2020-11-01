<template>
    <div class="main">
        <!-- 展示订单列表模块，判断数组的长度>0-->
       <div class="list" v-if=" orders.length>0">   

             <!-- item.id做key也可以 -->
           <div class="box" v-for="(item,index) of orders"   :key="index">

                 <!-- 跳转到/courseDetai，router文件夹里面路由 -->
                 <router-link :to ="{path:'/courseDetai', query:{video_id : item.video_id}}">

                       <!-- 订单对应的各项数据，包含下边两个div -->
                        <div class="smallbox">
                
                             <!-- 视频订单对应的图片 -->
                              <div class="imgdiv">
                                  <!-- alt:图片不显示时候，会显示名称 -->
                                  <img :src="item.video_img" alt="小滴课堂图片" />

                             </div>
                             

                             <!-- 视频订单对应的标题和价格 -->
                             <div class="textdiv"> 

                                   <p class="title">{{item.video_title}}</p>
                                   <!-- 保留两位小数点,toFixed(2) -->
                                   <p class="price"> {{(item.total_fee /100).toFixed(2)}}</p>  
                             </div>
                             

                        </div>
                        
                 </router-link>
           </div>

       </div>

       <!-- v-else 小于0，就走这个==没订单 -->
       <div class="no_order" v-else>
            <p>暂未购买课程</p>
       </div>

       <!-- 底部导航栏组件 -->
       <common-footer></common-footer>



    </div>

</template>


<script>
  
  import {getOrderList} from '@/api/getData.js'
  import CommonFooter from "@/components/CommonFooter"; //导入选项卡

   export default {
        //注册组件
         components:{
  
             CommonFooter
         },

     //数据源
     data() {

         return {

             //获得订单列表
              orders:[]
             
         }
     },

     //定义方法
     methods: {
         
         //获取订单列表
              async getOrderListData(){
                  
                  try {
                      //把token传进去
                      const   result  =  await getOrderList(this.$store.state.token);
                  if(result.data.code === 0){

                        this.orders = result.data.data || [] //如果数组为Null,就返回null,如果不为Null，就返回下边这个
                  }

                  } catch (error) {
                       console.log(error);
                  }
              } 
        },
          //定义vue实例生命周期,：⻚⾯渲染完成后,调⽤⽅法获取数据
          mounted() {
                this.getOrderListData();
      }
}

</script>






<style lang="scss" scoped>

.list {
 padding: 0 20px;
}
// 视频个体
.box {
 padding: 20px 0;
 background-color: #fff;
 border-bottom: 1px solid #ddd;
 // 标题
 .title {
 font-size: 14px;
 margin-bottom: 15px;
 }
 // 订单详情
 .smallbox {
 //flex左右排列，两端对⻬
 display: flex;
 justify-content: space-between;
 .imgdiv {
 width: 90px;
 height: 60px;
 flex-shrink: 0;
 img {
 width: 100%;
 height: 100%;
 border-radius: 10px;
 }
 }
 .textdiv p {
 margin-top: 10px;
 padding-left: 10px;
 }
 }
}
.no_order {
 margin-top: 50px;
 text-align: center;
}
</style>