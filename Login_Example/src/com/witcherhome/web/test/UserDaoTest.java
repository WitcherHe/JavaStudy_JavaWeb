package com.witcherhome.web.test;

import com.witcherhome.web.dao.UserDao;
import com.witcherhome.web.domain.User;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testLogin(){

        User loginUser = new User();
        loginUser.setUsername("witcher");
        loginUser.setPassword("Witcher92");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        System.out.println(user);
    }
}
