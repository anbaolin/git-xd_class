//封装基础请求,导入Axios。，
import axios  from 'axios'

//创建实列
const service = axios.create({
   //完整的url：baseURL+request url
     baseURL: "http://127.0.0.1:8089",
     //配置请求超时时间
     timeout: 5000

})


   //导出axios请求,全部导出法  export default 
   export default  service

