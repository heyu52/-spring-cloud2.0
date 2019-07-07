package com.csdn.demo.mapper;

import com.csdn.demo.enums.UserSexEnum;

public class UserParam {
    private String userName;

    private UserSexEnum userSex;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UserSexEnum getUserSex() {
        return userSex;
    }

    public void setUserSex(UserSexEnum userSex) {
        this.userSex = userSex;
    }
}
