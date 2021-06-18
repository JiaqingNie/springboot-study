package com.nie.mapper;


import com.nie.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    User queryUserByUsername(String username);

    User queryUserById(int id);

    List<User> queryUserList();

    int createUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

}
