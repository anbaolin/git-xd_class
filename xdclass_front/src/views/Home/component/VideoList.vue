<template>
  <div class="List-content">
    <div class="list">
      <!-- 遍历videoList,key:唯一标识, path:跳转到router路由包的courseDetail视频详情里来,
             跳转到视频详情:path:/courseDetail+ video_id -->
      <router-link
        v-for= "item in videoList"
        :key= "item.id"
        :to="{ path: '/courseDetail', query:{ video_id: item.id } }"
        class="course">
      
        <!--拿到视频列表上展示的图片 -->
        <div class="item_img">
          <img :src= "item.cover_img" />
        </div>

        <div class="video_info">
          <!--拿到视频标题 -->
          <div class="c_title"> {{ item.title }} </div>        
          <!--拿到视频价格 -->
          <div class="price">￥ {{ item.price / 100 }}</div>

        </div>
      </router-link>
    </div>
  </div>
</template>






<script>

export default {
  //从Home模块将视频列表data数据传到子组件VideoList.vue里.就是说:获取父组件传递过来的值，props:声明下传递过来的值的属性
  props: {
    videoList: {
      type: Array, //类型
      required: true, //是否是必须的，加true
    }
  }
}
</script>







<style lang="scss" scoped>
//列表包裹层边距
.list-content {
  margin-top: 20px;
  padding: 0 13px;
}
//视频包括层
.list {
  display: flex; //设置flex布局
  flex-wrap: wrap; //换⾏排列
  justify-content: space-between; //两端对⻬
  padding-bottom: 55px;
}
//视频个体层
.course {
  width: 48%;
  margin-bottom: 17px;
}
//视频图⽚
.item_img {
  font-size: 0; //消除图⽚元素产⽣的间隙
  box-shadow: 0 4px 11px 0 rgba(43, 51, 59, 0.6); //设置图⽚阴影，rgba前三个参数是颜⾊编码，最后⼀个是透明度
  border-radius: 8px; //设置图⽚圆⻆
  img {
    width: 100%;
    border-radius: 8px;
  }
}
.c_title {
  //设置超过两⾏隐藏 start
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  overflow: hidden;
  word-break: break-all;
  //设置超过两⾏隐藏 end
  font-size: 11px;
  height: 26px;
  line-height: 13px;
  margin-top: 10px;
  color: #2b333b;
}
//价格
.price {
  margin-top: 8px;
  font-size: 12px;
  color: #d93f30;
}
</style>