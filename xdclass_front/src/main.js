import Vue from 'vue'
import './cube-ui'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false


// 简介：前置守卫 路由拦截功能开发
// router⾥⾯配置需要登录的路由 meta : {requiresAuth: true}
// main.js⾥⾯配置路由拦截
//路由拦截，拦截全部路由，每次操作路由都是被拦截进⾏判断
router.beforeEach((to, from, next) => {
      const token = localStorage.getItem("token");
      //筛选需要传token的路由，匹配route⾥⾯需要登录的路径，如果匹配到就是true
      if (to.matched.some(record => record.meta.requiresAuth)) {
            //根据token是否有，判断是否需要调到登录⻚⾯
            if (token) {
                  next()
            } else {
                  next({ path: '/login' })
            }
      } else {
            next();
      }
})


new Vue({
      router,
      store,
      render: h => h(App)
}).$mount('#app')
