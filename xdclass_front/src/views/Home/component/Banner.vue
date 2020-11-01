<template>
  <div>
    <cube-slide  :data= "banners"> <!--这里使用banners，-->
      <cube-slide-item
        v-for= "(item, index) in banners" :key="index">  <!--遍历-->
        
        <!-- 把拿到的图片和url赋上去 -->
        <a :href= "item.url">
          <img :src= "item.img"  style="width:100%"/>
        </a>
      </cube-slide-item>
    </cube-slide>
  </div>
</template>


<script>

export default {
   //从Home模块将轮播图data数据传到子组件Banner.vue里.就是说:获取父组件传递过来的值，props；声明下传递过来的值的属性 
   props:{
     
       banners:{
            type:Array,  //类型
            required:true   //是否是必须的，加true
           
       }
   }

};

</script>


<style lang="scss" scoped>
</style>