package net.xdclass.demoproject2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

//用户实体类
public class User {

    private   int id;
    private   String  username;
   // @JsonIgnore   // 指定字段不返回：@JsonIgnore,指定密码不返回
    private  String  pwd;

  //无参构造方法
    public  User(){}

    //有参构造方法
    public  User(int id,String username,String pwd){

        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
