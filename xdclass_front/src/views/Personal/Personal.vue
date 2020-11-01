<template>
  <div>
    <div class="container">
        <div class="p_top">
            <div>
               <!-- head_img是后端用户信息下的头像,或 defaultHeadImg，就是vue自带的logo -->
                <img :src= 'info.head_img || defaultHeadImg' alt="头像"/>
                 <!-- 判断用户是否登录,如果token==null, 就是没登陆 -->
                <router-link to="/login" v-if = "getToken === ''"> 
                <p>立刻登录</p>
                </router-link>
                <p v-else>{{info.name}} </p>
            </div>
        </div>
        <!-- 判断下，如果token != null,才退出登录,给按钮一个点击事件,点击事件调用底部的-->
        <button v-if="getToken !== ''" class="green" @click="signOut">
            退出登录
        </button>
    </div>
    <common-footer></common-footer><!-- 在次加入选项卡底部组件 -->
  </div>
</template>

<script>
import CommonFooter from "@/components/CommonFooter";
import { getUserInfo } from "@/api/getData.js";
import defaultHeadImg from "@/assets/logo.png";

export default {
  components: {
    CommonFooter
  },

  data() {
    return {
      info: {},
      defaultHeadImg: defaultHeadImg
    };
  },

  computed: {
    getToken() {
      return this.$store.state.token;
    }
  },

  methods: {
    //获取用户信息
    async getInfo() {
      try {
        const result = await getUserInfo(this.getToken);
        if (result.data.code === 0) {
          this.info = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },

    //退出登录
    async signOut() {
      //清除token
      await this.$store.dispatch('clearToken');
      localStorage.removeItem("token");

      //刷新页面
      location.reload();
    }
  },

  mounted() {
    if (this.getToken) {
      this.getInfo();
    }
  }
};
</script>

<style lang="scss" scoped>
.container {
  // 顶部头像区域
  .p_top {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px 0;
    background-color: #2c3f54;
    div {
      text-align: center;
      img {
        width: 60px;
        height: 60px;
        border-radius: 50px;
      }
      p {
        font-size: 16px;
        color: #fff;
        margin-top: 10px;
      }
    }
  }
}
// 退出登录
.green {
  display: block;
  background-color: #3bb149;
  border: none;
  outline: none;
  width: 80%;
  height: 40px;
  margin: 20px auto 0;
  color: #fff;
  border-radius: 20px;
}
</style>