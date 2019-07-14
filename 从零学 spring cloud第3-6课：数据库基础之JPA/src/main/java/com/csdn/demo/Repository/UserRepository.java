package com.csdn.demo.Repository;

import com.csdn.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    ArrayList<User> findByName(String name);
    ArrayList<User> findByNameOrSex(String name, String sex);
    Long deleteByName(String name);
    Long countByName(String name);
}
