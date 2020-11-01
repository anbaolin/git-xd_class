<template>
<!-- ⼩滴课堂CourseDetail的Catalog⽬录⼦组件开发 -->
     <div class="cate_box">
             
         <div>
             <!-- 遍历章信息, key就是章的id-->
             <ul class="content" v-for= "(item , ind)  in  chapterList" :key="item.id">
                 
                      <h1> 第{{ind +1}}章 &nbsp;{{item.title}} </h1>
                     <!-- 遍历集信息,先遍历章信息，拿到章的下标ind, episode_list:集的数组列表必须拿过来,    key就是集的id -->
                      <li class="sub_cate" v-for="(item,subint) in  chapterList[ind].episode_list" :key="item.id">
                          <span class="sub_title">{{ind+1}}-{{subint+1}} &nbsp; {{item.title}}</span>
                          
                     </li>
             </ul>
         </div>   

    </div>    
       
</template>




<script>


export default {
    
    //从Tab模块将章集组件chapterList传到子组件Calalog.vue里,获取父组件传递过来的值，props:声明下传递过来的值的属性
    props:{

             chapterList:{

                   type:Array,  //类型
                  required: true //是否是必须的，加true
             }
    }
}


</script>



<style lang="scss" scoped>
// ⽬录包裹层设置边距
.cate_box {
 padding: 0 15px 50px;
 background-color: #fff;
 margin: 15px 0;
}

//每⼀章包裹层
.content {
 padding: 10px;

 // 章标题
 & h1 {
 font-size: 16px;
 width: 100%;
 margin-bottom: 15px;
 font-weight: bolder;

 // 设置章标题过⻓,超过⾏宽度省略隐藏
 text-overflow: ellipsis;
 overflow: hidden;
 white-space: nowrap;
 }
}
//集包裹层
.sub_cate {
 font-size: 12px;
 padding: 10px 0;
 //集标题
 .sub_title {
 // 设置集标题过⻓,超过⾏宽度省略隐藏
 display: block;
 text-overflow: ellipsis;
 overflow: hidden;
 white-space: nowrap;
 }
}
</style>