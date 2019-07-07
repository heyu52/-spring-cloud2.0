package com.csdn.demo.model;

import com.csdn.demo.enums.UserSexEnum;

public class User {
    private Long id;
    private String name;
    private int age;
    private UserSexEnum sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return ("id=" + this.id + "name=" + this.name + ",age=" + this.age + ",pass=" + this.sex);
    }

    public User() {

    }

    public User(String name, UserSexEnum sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}