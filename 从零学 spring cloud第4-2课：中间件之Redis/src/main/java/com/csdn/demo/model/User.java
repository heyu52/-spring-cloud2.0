package com.csdn.demo.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String userName;
    private String regTime;

    public User() {
        super();
    }
    public User(String userName, String regTime) {
        super();
        this.userName = userName;
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }
}