

<template>
    <!-- 视频详情页面顶部栏开发 -->
    <div>
        <header>
                <div class="header">
                       <!-- 点击事件，点击符号cubeic-person跳转到上一级Home主页面 -->
                      <span @click= "$router.back(-1)">
                       <i class="cubeic-back"> </i>                                             
                      </span>
                      <!-- 拿到标题数据 -->
                      <div class="title">
                        {{ videoInfo.title}}
                      </div>
               </div>
        </header>

    </div>

</template>



<script>

export default {
    //从CourseDetail.vue模块将页面顶部的组件,传到子组件Header.vue里,获取父组件传递过来的值，props:声明下传递过来的值的属性
    props:{

         videoInfo:{
             type: Object,//类型
             required: true //是否是必须的，加true

          }
     }
}


</script>


<style lang="scss" scoped>
.header {
 display: flex;//flex左右布局
 background-color: #07111b;
 padding: 10px 20px;
 color: #fff;
}
// 返回箭头
.cubeic-back {
 color: #fff;
 margin-right:5px;
}
//视频标题
.title {
 font-size: 16px;
 width: 80%;
 //超出省略
 text-overflow: ellipsis;
 overflow: hidden;
 white-space: nowrap;
}
</style>