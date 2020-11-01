

<!--⼩滴课堂移动端cube-tab-bar选项卡开发


mac格式化代码：shift + option + F
windows格式化代码: shift + alt + F

template开发  ,把选项卡组件作为一个通用的，因为都得用到选项卡，所有说做成通用的
-->
<template>
  <div class="tab">
      <!--cube-tab-bar就ui的组件，从官方文档拿到-->
    <cube-tab-bar v-model= "selectedLabelSlots" @click= "changHandler">
      <!--tabs：那个ui组件的选项卡数组,v-for遍历它, 拿到各个值.  最后value的值就是我们要跳转的那个个路由-->
      <cube-tab
        v-for= "item in tabs"
        :icon= "item.icon"
        :label= "item.label"
        :key= "item.path"
        :value= "item.path"
      >
      </cube-tab>
    </cube-tab-bar>
  </div>
</template>



<script>
export default {    
  //数据源  ，这里对应的 是 router文件夹下的 index.js文件，他里面的routes(路由跳转到指定的模块， 就是views文件夹里的模块)
  data() {
    return {
      selectedLabelSlots: "/", //选项卡
     
     //选项卡数组
      tabs: [
        {
          label: "首页",
          icon: "cubeic-home", //组件的样式
          path: "/"    //跳转到router文件夹下的 index.js文件，就是他里面的routes.   [(routers 就是views文件夹里的模块]
        },

        {
          label: "我的订单",
          icon: "cubeic-like",  //组件的样式
          path: "/order"
        },
        {
          label: "个人中心",
          icon: "cubeic-person",  //组件样式
          path: "/personal"  
          //path: "/register"之前为了测试注册在这改成这样，现在还原了，把注册路径注掉
        }
      ]
    };
  },
    
    //上面的点击事件changHandler  ,这里定义一个methods
    methods: {
        
       changHandler(path){
            //不等于,  $route.path:当前的路由   
            if(path!=this.$route.path){  //当前激活的路由对象，包含了当前的路由信息

                // router.push:导航到不同的path路径，这个⽅法会向 history栈添加⼀个新的记录，所以当⽤户点击浏览器后退按钮时，则回到之前的 URL。
                this.$router.push(path)
            }
       }   
    },

     //定义vue实例生命周期,：在模板渲染成html前调⽤，即通常初始化某些属性值，然后再渲染成视图
      created() {
           //默认路由选择器，比如刷新页面,需要重新进到当前路由
           this.selectedLabelSlots  = this.$route.path // this.$route.path :当前激活的路由对象，包含了当前的路由信息
      }
};

</script>


<!--SCSS是⼀种CSS预处理语⾔, scoped 是指这个scss样式 只作⽤于当前组件-->
<style lang="scss" scoped>
.tab {
 position: fixed;
 bottom: 0;
 z-index: 999;
 background-color:#fff;
 width: 100%;
 border-top: 1px solid rgba($color: #000000, $alpha: 0.1);
}
.cube-tab_active {
 color: #3bb149;
 }
</style>