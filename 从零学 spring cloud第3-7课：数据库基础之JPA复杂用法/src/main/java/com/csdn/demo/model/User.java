package com.csdn.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findBySex3", query = "select u from User u where u.sex = ?1"),
        @NamedQuery(name = "User.findByName3", query = "select u from User u where u.name = ?1") })
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private int age;

    public User() {
    }

    public User(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(String age) {
        this.sex = age;
    }


    @Override
    public String toString() {
        return this.getId() + "," + this.getName() + "," + this.getSex() + "," + this.getAge();
    }
}