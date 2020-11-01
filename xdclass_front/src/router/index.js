import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home/Home.vue'     //导入views里的模块
import CourseDetail from '../views/CourseDetail/CourseDetail.vue'   //导入views里的模块
import Login from '../views/Login/Login.vue'
import Order from '../views/Order/Order.vue'
import Pay from '../views/Pay/Pay.vue'
import  Personal from'../views/Personal/Personal.vue'
import Register from '../views/Register/Register.vue'

//router和vue绑定
Vue.use(VueRouter)

//路由跳转，跳转到指定的模块， 就是views文件夹里的模块
const routes = [
     {
       //首页
        path:"/",
        name:"Home",
        component:Home
     },
      

     {
      path:"/courseDetail",  //小写    视频详情
      name:"CourseDetail",
      //按需加载
      component : ()=>import("../views/CourseDetail/CourseDetail.vue")    
      //component:CourseDetail
     },


     {
      path:"/login",  //小写   登录
      name:"Login",
      component:Login
     },

    //  ⼩滴课堂前端项⽬实战之路由拦截功能开发
    //  router⾥⾯配置需要登录的路由 meta:{requiresAuth: true},
    //  前置守卫 路由拦截功能开发: meta : {requiresAuth: true}    
     {
      path:"/order",  // 订单
      name:"Order",
      component:Order,
      meta:{requiresAuth: true} 
     },

     {
      path:"/pay",  //这里都用小写
      name:"Pay",
      component:Pay,   //支付
      meta:{requiresAuth: true} 
     },

     {
      path:"/personal", //这里都用小写，个人中心
      name:"Personal",        
      component:Personal,
      meta:{requiresAuth: true}
     },

     {
      path:"/register",      //注册
      name:"Register",
      component:Register
     },
]

//new VueRouter绑定routes.VueRouter和上面的实例已经绑定了
 const router = new VueRouter({
  routes
})

export default router //导出去
