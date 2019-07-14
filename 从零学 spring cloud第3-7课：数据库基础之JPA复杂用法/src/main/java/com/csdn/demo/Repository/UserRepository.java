package com.csdn.demo.Repository;

import com.csdn.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    ArrayList<User> findByName(String name);

    ArrayList<User> findByNameOrSex(String name, String sex);

    Long deleteByName(String name);

    Long countByName(String name);

    @Query("select u from User u")
    Page<User> findAllUser(Pageable pageable);

    @Query(value = "select * from user u where u.name = ?1", nativeQuery = true)
    Page<User> findByUserName(String nickName, Pageable pageable);

    @Query(value = "select * from user u where u.name = :name", nativeQuery = true)
    Page<User> findByUserName2(@Param("name") String name, Pageable pageable);

    @Transactional(timeout = 10)
    @Modifying
    @Query("update User set Name = ?1 where id = ?2")
    int updateUserNameById(String name, Long id);


    List<User> findBySex3(String sex);
    List<User> findByName3(String name);
}
