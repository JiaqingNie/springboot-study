package com.nie.service;

import com.nie.pojo.User;

import java.util.List;

public interface UserService {
    User queryUserByUsername(String username);

    User queryUserById(int id);

    List<User> queryUserList();

    int createUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
