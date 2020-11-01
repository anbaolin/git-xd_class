<template>
    
    <div class="c_wapper">

        <div class="course">
           <div class="l_img">
               <!-- 获取图片和标题 -->
               <img :src= "videoInfo.cover_img"  :title= "videoInfo.title"/>
           </div>
           
           <!-- 取右边的元素 -->
          <div class="r_txt">
                <div class="txt">
                    <span>综合评分!</span>
                    <p>{{videoInfo.point}}</p>
                    
                </div>

                  <div class="txt">
                    <span>价格:</span>
                    <p>￥{{videoInfo.price}}</p>                   
                  </div>
                
          </div>
       </div>

    </div>
</template>








<script>

export default {
    //从父组件传内容过来--//视频详情信息
       props:{
               
           videoInfo:{
                
                 type: Object,//类型

                 required: true //是否是必须的，加true

             }   
       }
}


</script>





<style lang="scss" scoped>

//包裹层
.c_wapper {

 padding: 0 14px;
}
//视频信息包裹层
.course {
 margin:14px 0;
 display:flex;//设置flex，左右布局
}
//视频左边图⽚层
.l_img {
 height:88px;
 margin-right:14px;
 & img {
 height:100%;
 border-radius:15px;
 }
}
// 视频右边⽂字包裹层
.r_txt {
 padding:6px 0;
 font-size:12px;
 flex:1;//设置1可⾃动伸缩占⽤剩余空间
}
//每⾏⽂字层（综合评分、价格）
.txt {
 // 设置flex让⽂字两端对⻬
 display:flex;
 justify-content:space-between;
 line-height:16px;
 & p {
 text-align:center;
 width:40%;
 color:#3bb149;
 }
 & i {
 color:#666;
 font-weight:bolder;
 width:60%;
 & span {
 color:#2b333b;
 font-size:12px;
 }
 }
}
</style>