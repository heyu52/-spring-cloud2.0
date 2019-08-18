package com.csdn.demo.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<com.csdn.demo.model.User, Long> {

    com.csdn.demo.model.User findByUserName(String userName);

    Page<com.csdn.demo.model.User> findAll(Pageable pageable);
}