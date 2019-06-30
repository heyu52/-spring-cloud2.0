package com.example.demo.demo.RepositoryImpl;

import com.example.demo.demo.Common.MyException;
import com.example.demo.demo.Repository.UserRepository;
import com.example.demo.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(User user) {
        int k = jdbcTemplate.update("INSERT INTO user(name, sex, age) values(?, ?, ?)",
                user.getName(), user.getSex(), user.getAge());
        return k;
    }


    @Override
    @Transactional(rollbackFor = MyException.class)
    public void saveThenRollback(User user) throws MyException {
        int k = jdbcTemplate.update("INSERT INTO user(name, sex, age) values(?, ?, ?)",
                user.getName(), user.getSex(), user.getAge());

        throw new MyException();
    }


    @Override
    public int update(User user) {
        return jdbcTemplate.update(
                "UPDATE user SET name = ? , sex = ? , age = ? WHERE id=?",
                user.getName(), user.getSex(), user.getAge(), user.getId());
    }

    @Override
    public int delete(long id) {
        return jdbcTemplate.update("DELETE FROM user where id = ? ", id);
    }

    //new BeanPropertyRowMapper<User>(User.class) 对返回的数据进行封装，它可自动将一行数据映射到指定类的实例中，
    // 首先将这个类实例化，然后通过名称匹配的方式，映射到属性中去。
    @Override
    public User findById(long id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM user WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<User> findAllUser() {
        return jdbcTemplate.query("SELECT * FROM user", new UserRowMapper());
    }

    //UserRowMapper 继承了 RowMapper，RowMapper 可以将数据中的每一行数据封装成用户定义的类，
    // 实现 RowMapper 接口覆盖 mapRow 方法，在 mapRow 方法封装对数据的返回处理。
    // 通过上面代码可以看出 UserRowMapper 循环遍历了查询返回的结果集，
    // 遍历的同时按照属性进行赋值。这样在查询使用时只需要传入 new UserRowMapper() 即可自动解析返回数据。
    class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getInt("age"));

            return user;
        }
    }
}