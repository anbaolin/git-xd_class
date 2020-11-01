
//导入axios实列,  ./当前目录  ../上一级目录
import axios from '../request'




//注册接口, const:常量  ,  registerApi名称
export  const registerApi = (phone,pwd,name) => axios.post("/api/v1/pri/user/register",{

       "phone":phone,
       "pwd":pwd,
       "name":name
})





//登录接口,
export const loginApi = (phone,pwd) => axios.post("/api/v1/pri/user/login",{
     //自动会把key value补充，自动转换成 上面那种写法
      phone,
      pwd
})




//轮播图接⼝
export const getBanner = () => axios.get("/api/v1/pub/video/list_banner")



//视频列表接⼝
export const getVideoList = ()=> axios.get("/api/v1/pub/video/list")





 //视频详情,后端是根据id查询视频详情
 export const getVideoDetail = (vid)=>axios.get("/api/v1/pub/video/find_detail_by_id?",{
  params: {
  video_id:vid
  }
 })


 
 
//下单接⼝
export const saveOrder = (token, vid)=>axios.post("/api/v1/pri/order/save",{
    "video_id":vid
   },{
    headers:{
    "token":token
    }
   })



  //订单列表接口
//订单列表
export const getOrderList = (token)=>axios.get("/api/v1/pri/order/list",{
    params:{
    "token":token
    }
   })




//⽤户信息接⼝
export const getUserInfo =(token)=>axios.get("/api/v1/pri/user/find_by_token",{
 params:{
 "token":token
 }
})

