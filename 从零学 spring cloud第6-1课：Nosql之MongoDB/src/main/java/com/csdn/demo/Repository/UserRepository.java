package com.csdn.demo.Repository;

import com.csdn.demo.model.User;
public interface UserRepository {

    public void saveUser(User user);

    public void deleteUserById(Long id);

    public long updateUser(User user);

    public User findUserByUserName(String userName);
}
