package com.witcherhome.web.dao;

import com.witcherhome.web.domain.User;
import com.witcherhome.web.unit.JDBCUnit;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    //声明JDBCTemplate对象公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUnit.getDataSource());

    /**
     * login
     * @param loginUser only has username and password
     * @return user contain all users data
     */
    public User login(User loginUser){
        String sql = "select * from user where username=? and password=?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class),
                loginUser.getUsername(),
                loginUser.getPassword());

        return user;
    }
}
