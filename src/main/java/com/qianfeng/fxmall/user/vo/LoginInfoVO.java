package com.qianfeng.fxmall.user.vo;

public class LoginInfoVO {
  private   String phone;
   private  String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginInfoVO(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }
}
