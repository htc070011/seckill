package com.bupt.miaoshao.vo;

import com.bupt.miaoshao.validator.isMobile;

import javax.validation.constraints.NotNull;

public class LoginVO {

    @NotNull
    @isMobile
    private String mobile;

    @NotNull
    private String password;

    public LoginVO() {
    }

    public LoginVO(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVO{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
