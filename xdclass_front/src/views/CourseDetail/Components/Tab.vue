<template>
      
      <div class="tabs">
           <!-- ⼩滴课堂CourseDetail的tab⼦组件开发和vue的动态组件讲解 
           cube-tab-bar
            支持默认的点击高亮效果，又支持下划线跟随的效果
           
           -->
             <cube-tab-bar v-model= " selectedLabel"  show-slider inline>

                  <cube-tab v-for= "item in tabs"  :label= "item.label" :key= "item.label"></cube-tab>
                            
             </cube-tab-bar>

              <!--三目运算符，is判断selectedLabel是否是简介，如果是就=Summary,如果不是就=Catalog. 

               这里使用了vue的动态组件 -->
            <component :videoInfo ="videoInfo"  :chapterList = "chapterList" :is='selectedLabel=="简介"? "Summary":"Catalog"'>
             </component>  
      </div>
   
</template>

<script>

//导入组件，这两个组件是在Tab里的，所以导入到Tab里
import Summary from './Summary'
import Catalog from './Calalog'


export default {
    
      //注册组件，也叫声明组件
      components:{

           Summary,
           Catalog

      },

    //从CourseDetail.vue模块将视频tab简介组件两个参数,包含章 集组件,传到子组件Tab.vue里,获取父组件传递过来的值，
    //props:声明下传递过来的值的属性
    props:{
            
          chapterList:{
               type:Array,  //类型
               required: true //是否是必须的，加true

          },

          videoInfo:{
             type: Object,  //类型
             required: true //是否是必须的，加true

          }

    },

    //数据源
      data() {
       
          return {
              
              selectedLabel:"简介",
              //选项卡数组
              tabs:[

                  {
                      label:"简介"
                  },
             
                  {
                      label:"目录"

                  }    
              ]
              
          }
      }

     
}


</script>



