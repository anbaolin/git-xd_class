package net.xdclass.demoproject2;
         /* 回顾javaweb通过原⽣jdbc访问数据库
          简介：回顾基础使⽤原⽣jdbc访问数据库
          Springboot项⽬测试原⽣JDBC连接*/


import java.sql.*;

public class JdbcApp {

    public static void main(String[] args) throws Exception {
       /* 注意：本地安装Myql务必使⽤5.7版本
        原⽣jdbc访问数据库步骤:
                加载JDBC驱动程序
        创建数据库的连接
                创建preparedStatement
        执⾏SQL语句
                处理结果集
        关闭JDBC对象资源*/
          String  url =  "jdbc:mysql://127.0.0.1:3306/xdclass?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8&useSSL=false";
          String  user = "root";
          String  password ="123456";
          String  driverClass ="com.mysql.cj.jdbc.Driver";


            Class.forName(driverClass);
            Connection  connection  =  DriverManager.getConnection(url,user,password);

            Statement statement  =    connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("select * from video");

            while (resultSet.next()){

                   System.out.println(resultSet.getString("title"));
            }

           statement.close();
            resultSet.close();
    }

}
