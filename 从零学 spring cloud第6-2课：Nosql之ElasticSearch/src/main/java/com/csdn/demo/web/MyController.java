package com.csdn.demo.web;

import com.csdn.demo.Repository.UserRepository;
import com.csdn.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @RequestMapping("saveUsers")
    public void saveUsers() {
        repository.save(new User("csdn01", "深圳01", 11));
        repository.save(new User("csdn02", "深圳02", 12));
        repository.save(new User("csdn03", "深圳03", 13));
        repository.save(new User("csdn04", "深圳04", 14));
        repository.save(new User("csdn05", "深圳05", 15));
        repository.save(new User("csdn06", "深圳01", 16));

    }

    @RequestMapping("fetchAllUsers")
    public String fetchAllCustomers() {
        Iterable<User> iterable = repository.findAll();

        String value="";

        for (User user :iterable) {
            value+= user.toString();
        }

        return value;
    }
    @RequestMapping("updateUsers")
    public String updateUsers() {

        User user= repository.findByUserName("csdn04");
        user.setAddress("深圳007");
        repository.save(user);
        user=repository.findByUserName("csdn04");
        return user.toString();
    }
    @RequestMapping("fetchPageUsers")
    public String fetchPageUsers() {

        Sort sort = new Sort(Sort.Direction.DESC, "address.keyword");
        Pageable pageable = PageRequest.of(0, 10, sort);
        Page<User> users=repository.findByAddress("深圳01", pageable);

        return users.getContent().toString();
    }
}
