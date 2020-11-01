
// vuex是一个专为 Vue.js 应用程序开发的状态管理模式。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化
// 将组件的共享状态抽取出来，以一个全局单例模式管理呢？在这种模式下，我们的组件树构成了一个巨大的“视图”，不管在树的哪个位置，任何组件都能获取状态或者触发行为！
// 通过定义和隔离状态管理中的各种概念并通过强制规则维持视图和状态间的独立性，我们的代码将会变得更结构化且易维护。

import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    token: localStorage.getItem("token") || '' //加Null表示后续别的组件拿token时候，以Null串做判断
  },
  //同步修改state里面的值
  mutations: {
     //把值扶赋进去，调用这个方法，访问上面的 token: localStorage.getItem("token")进行修改
    SET_TOKEN:(state, token)=>{
      state.token = token
    }
  },
 //异步调用mutations里面的方法
  //利用上下文context,触发
  actions: {
    setToken(context,token){
      context.commit('SET_TOKEN',token)
    },

    //不登录,清除token方法
    clearToken(context){
      context.commit('SET_TOKEN','')
    }

  },
  modules: {
  }
})
