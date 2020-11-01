<template>
 <div class="main">
 <cube-form :model="model" @submit="submitHandler">

 <cube-form-group>
 <!--⼿机号-->
 <cube-form-item :field="fields[0]"></cube-form-item>
 <!--密码-->
 <cube-form-item :field="fields[1]"></cube-form-item>
 </cube-form-group>


 <cube-form-group>
 <cube-button type="submit">登录</cube-button>
 </cube-form-group>

 </cube-form>
  <!-- 这是登录模块里面的注册,连接到router文件夹里的/register登录模块 -->
 <router-link to="/register" class="reg">注册</router-link>
 </div>
</template>

 
<script>
//按需导入登录接口Api
import {loginApi} from '@/api/getData.js'


export default {
    data() {
        return {
            model:{
                 phoneValue: "",
                 pwdValue: ""

            },

              //定义校验规则
      fields: [



        //手机号
        {
          type: "input",
          modelKey: "phoneValue",
          label: "手机号",
          props: {
            placeholder: "请输入手机号",
          },

          rules: {
            //必填的，true
            required: true,
          },

          messages: {
            required: "手机号不能为空",
          }
        },



        //密码
        {
          type: "input",
          modelKey: "pwdValue",
          label: "密码",
          props: {
            placeholder: "请输入密码",
            type:"password", //类型 
          eye: {
            open: false,
          }
          },
          rules: {
            //必填的，true
            required: true,
          },

          messages: {
            required: "密码不能为空",
          }
        }
      ]

     }
    },


    //定义一个方法，二次提交用户的数据，防止二次事件产生，这里使用了Cube-UI里的"弹出层toast:事件回调"
  methods: {
    submitHandler(e, model) {
      //防止默认的提交，防止事件冒泡
      e.preventDefault();
      //调用登录接口,并且拿到结果
      loginApi(model.phoneValue, model.pwdValue).then(
        (response) => {
          //如果状态码=0，就提交数据登录成功
          if (response.data.code === 0) {
              //登录成功，拿到token存储在localStorage里，页面关闭他不消失，sessionStorage会消失
                 localStorage.setItem("token",response.data.data)
                 
                 //调用store文件里的vuex触发mutations里面某个方法,而vue代码里通过this $store.dispatch触发actions里面定义的方法
                 this.$store.dispatch('setToken',response.data.data)
                 ///跳转页面, 根据业务需要
                   this.$router.push({path:'/personal'})

          }else{
               // 通过 $events 传入事件回调。
            const toast = this.$createToast({
              //用一个变量toast接收
              txt: "登录失败",
              type: "error", 
              time: 1500,
            });
            toast.show(); //展示数据

          }
        }
      );
    }
  }
};


</script>



<style lang="scss" scoped>
.main {
 padding: 50px 5% 0;
 text-align: center;
}

// 登录
.cube-btn {
 margin-top: 20px;
}

//注册
.reg {
 display: inline-block;
 margin-top: 30px;
 font-size: 18px;
}
</style>