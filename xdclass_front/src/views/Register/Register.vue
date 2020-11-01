<template>
<!-- 使用了Cube-UI里的Form表单 -->
  <div class="main">
    <cube-form :model="model" @submit="submitHandler">

      <cube-form-group>
          <!-- 名称 -->
        <cube-form-item :field="fields[0]"></cube-form-item>
         <!-- 手机号 -->
        <cube-form-item :field="fields[1]"></cube-form-item>
         <!-- 密码 -->
        <cube-form-item :field="fields[2]"></cube-form-item>     
      </cube-form-group>

      <cube-form-group>
        <cube-button type="submit">注册</cube-button>
      </cube-form-group>

    </cube-form>

     <!-- 这是注册模块里面的登录,连接到router文件夹里的/login登录模块 -->
    <router-link to="/login" class="reg">登录</router-link> 
  </div>
</template>





<script>
//按需导入注册接口Api
import {registerApi} from "@/api/getData.js";

export default {
  data() {
    return {
      model: {
        //表单的模型，需要哪些
        phoneValue: "",
        pwdValue: "",
        nameValue: "",
      },
      //定义校验规则
      fields: [

          //名称
        {
          type: "input",
          modelKey: "nameValue",
          label: "名称",
          props: {
            placeholder: "请输入名称",
          },

          rules: {
            //必填的，true
            required: true,
          },

          messages: {
            required: "名称不能为空",
          }
        },


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
      //调用注册接口,并且拿到结果
      registerApi(model.phoneValue, model.pwdValue, model.nameValue).then(
        (response) => {
          //如果状态码=0，就提交数据注册成功
          if (response.data.code === 0) {
            // 通过 $events 传入事件回调。
            const toast = this.$createToast({
              //用一个变量toast接收
              txt: "注册成功",
              type: "correct", //正确
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
//注册
.cube-btn {
 margin-top: 20px;
}
// 登录
.reg {
 display: inline-block;
 margin-top: 30px;
 font-size: 18px;

}
</style>