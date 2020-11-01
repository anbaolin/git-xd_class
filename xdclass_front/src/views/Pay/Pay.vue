<template>
  <div>
    <!--视频信息 -->
    <div class="info">
      <p class="info_title">商品信息</p>
      <!--商品的详情 -->
      <div class="box">
        <div class="imgdiv">
          <img alt="课程照片" :src="videoinfo.cover_img" />
        </div>

        <!--title视频标题 -->
        <div class="textdiv">
          <p class="c_title">{{ videoinfo.title }}</p>
          <p class="price">
            <!-- .toFixed(2)保留两位小数 -->
            ￥:&nbsp;&nbsp;{{ (videoinfo.price / 100).toFixed(2) }}
          </p>
        </div>
      </div>
    </div>

    <!-- 底部的支付组件-->
    <div class="footer">
      <p class="money">
        <!-- toFixed(2)保留两位小数点 -->
        实付款: &nbsp;&nbsp; {{ (videoinfo.price / 100).toFixed(2) }}
      </p>

      <!-- 支付按钮 -->
      <p class="submit" @click="pay">⽴刻⽀付</p>
    </div>
  </div>
</template>






<script>
//导入视频详情Api接口和下单接口
import { getVideoDetail, saveOrder } from "@/api/getData.js";

export default {
  data() {
    return {
      //视频信息
      videoinfo: {},
    };
  },
  //自定义方法
  methods: {
    //获取视频详情
    async getDetail(vid) {
      try {
        const result = await getVideoDetail(vid);

        //如果状态码=0
        if (result.data.code === 0) {
          //拿到数据
          this.videoinfo = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },
    //下单
    async pay() {
      try {
        const result = await saveOrder(
          this.$store.state.token,
          this.$route.query.video_id
        );

        if (result.data.code === 0) {
          const toast = this.$createToast({
            //用一个变量toast接收
            txt: "购买成功",
            type: "correct",
            time: 2000,
            //定时器，下单之后，跳转到订单页面
            onTimeout: () => {
              this.$router.push({ path: "order" });
            },
          });
          toast.show(); //展示数据
          //下单失败
        } else {
          const toast = this.$createToast({
            //用一个变量toast接收
            txt: "下单失败",
            type: "error",
            time: 1500,
          });
          toast.show(); //展示数据
        }
      } catch (error) {
        console.log(error);
      }
    },
  },

  mounted() {
    // console.log(this.$route.query.video_id); //打印传过来的video_id  测试时用
    //定义vue实例生命周期,：⻚⾯渲染完成后,调⽤⽅法从后端获取数据
    this.getDetail(this.$route.query.video_id);
  },
};
</script>



<style lang="scss" scoped>
// 视频标题
.info_title {
  padding: 10px 20px;
  background-color: #fff;
  border-bottom: 1px solid #d9dde1;
}
.box {
  background-color: #fff;
  box-sizing: border-box;
  padding: 20px;
  display: flex;
  margin-bottom: 15px;
  .imgdiv {
    width: 105px;
    height: 59px;
    flex-shrink: 0;
    img {
      width: 100%;
      height: 100%;
    }
  }
  .textdiv {
    margin-left: 20px;
    height: 59px;
    flex-grow: 1;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    .price {
      flex-shrink: 0;
    }
  }
}
//底部
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  height: 50px;
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.1);
  font-size: 16px;
  .money {
    height: 50px;
    line-height: 50px;
    flex: 2;
    text-align: center;
    background-color: #fff;
  }
  .submit {
    height: 50px;
    line-height: 50px;
    flex: 1;
    text-align: center;
    background-color: #ff2d50;
    color: #fff;
  }
}
</style>