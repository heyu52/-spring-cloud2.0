package com.example.demo.demo.Repository;

import com.example.demo.demo.model.User;

import java.util.List;

public interface UserRepository {
    int save(User user);

    int update(User user);

    int delete(long id);

    List<User> findAllUser();

    User findById(long id);
}
