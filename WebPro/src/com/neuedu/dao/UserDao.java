package com.neuedu.dao;

import com.neuedu.pojo.User;

public interface UserDao {
    void register(String user,String psw);
    User login(User user);
}
