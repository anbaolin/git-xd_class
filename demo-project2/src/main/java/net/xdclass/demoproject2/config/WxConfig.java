package net.xdclass.demoproject2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//存放微信支付配置文件

@Configuration
@PropertySource("classpath:pay.properties")
public class WxConfig {
      @Value("${wxpay.appid}")
      private   String  payAppid;
      @Value("${wxpay.sercret}")
      private  String  paySercret;
      @Value("${wxpay.mechid}")
      private  String  paymechId;





      public String getPayAppid() {
            return payAppid;
      }

      public void setPayAppid(String payAppid) {
            this.payAppid = payAppid;
      }

      public String getPaySercret() {
            return paySercret;
      }

      public void setPaySercret(String paySercret) {
            this.paySercret = paySercret;
      }

      public String getPaymechId() {
            return paymechId;
      }

      public void setPaymechId(String paymechId) {
            this.paymechId = paymechId;
      }
}
