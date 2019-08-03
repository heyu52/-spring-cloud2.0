package com.csdn.demo.mapper;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class UserSql {

    public String getUserCount(UserParam userParam) {
        String sql = new SQL() {{
            SELECT("COUNT(1)");
            FROM("user");

            if (!StringUtils.isEmpty((userParam.getUserName()))) {
                WHERE("name=#{userName}");
            }

            if (!StringUtils.isEmpty((userParam.getUserSex()))) {
                WHERE("sex=#{userSex}");
            }

        }}.toString();

        System.out.println("sql :" + sql);
        return sql;
    }

}
