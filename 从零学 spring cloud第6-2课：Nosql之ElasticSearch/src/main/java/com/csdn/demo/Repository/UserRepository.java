package com.csdn.demo.Repository;

import com.csdn.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    public List<User> findByAddress(String address);

    public User findByUserName(String userName);

    public int  deleteByUserName(String userName);

    public Page<User> findByAddress(String address, Pageable pageable);

}