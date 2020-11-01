<template>
<!-- ⼩滴课堂CourseDetail的summary⼦组件开发 -->
    <div>
       <img class="summary" :src= "videoInfo.summary">
   </div>


</template>
  



<script>

export default {
    
     props:{
        //从Tab模块将组件,传到子组件Summary.vue里,获取父组件传递过来的值，props:声明下传递过来的值的属性
            videoInfo:{

                type: Object,//类型
                required: true //是否是必须的，加true

          }
     }

}


</script>



<style lang="scss" scoped>
.summary {
 width:100%;
 padding-bottom:50px;
 margin:15px 0;
}

</style>