package com.csdn.demo.mapper;

import com.csdn.demo.enums.UserSexEnum;
import com.csdn.demo.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM user WHERE id = #{id}")
//    User getUserById(Long id);

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "sex",  column = "sex", javaType = UserSexEnum.class),
    })
    User getUserById(Long id);

    @Select("SELECT * FROM user WHERE sex = #{sex} and age > #{age}")
    List<User> getUserByNameAndAge(@Param("sex") String userSex, @Param("age") int userage);

    @Select("SELECT * FROM user WHERE sex = #{sex} and age > #{age}")
    List<User> getUserByMapParam(Map<String,Object> args);

    @Insert("INSERT INTO user(name,sex,age) VALUES(#{name}, #{sex}, #{age})")
    void insertUser(User user);

    @Update("UPDATE user SET name=#{name}  WHERE id =#{id}")
    void updateUser(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void deleteUser(Long id);

    @Update({"<script> ",
            "update user  " ,
            "<set>" ,
            " <if test='name != null'>name=#{name},</if>" ,
            " <if test='age > 99 '>age=#{age},</if>" ,
            " </set> ",
            "where id=#{id} " ,
            "</script>"})
    void updateUserByScript(User user);

    @SelectProvider(type = UserSql.class, method = "getUserCount")
    int getUserCount(UserParam userParam);

}
