package com.nie.service.impl;

import com.nie.mapper.UserMapper;
import com.nie.mapper.UserRoleMapper;
import com.nie.pojo.Role;
import com.nie.pojo.User;
import com.nie.service.RoleService;
import com.nie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public int createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int res = userMapper.createUser(user);
        int userId = userMapper.queryUserByUsername(user.getUsername()).getId();
        for (String role : user.getRoleSet()){
            int roleId = roleService.queryRoleByName(role).getId();
            userRoleMapper.addRoleToUserById(userId, roleId);
        }
        return res;
    }

    @Override
    public int updateUser(User user) {
        int userId = user.getId();
        User preUser = userMapper.queryUserById(userId);

        String prePassword = preUser.getPassword();
        if (prePassword != null && !prePassword.equals(user.getPassword())){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }

        Set<String> preRoleSet = preUser.getRoleSet();
        Set<String> currRoleSet = user.getRoleSet();

        updateUserRoles(userId, preRoleSet, currRoleSet);

        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }

    private void updateUserRoles(int userId, Set<String> pre, Set<String> curr){
        for (String role : pre){
            if (!curr.contains(role)){
                int roleId = roleService.queryRoleByName(role).getId();
                userRoleMapper.removeRoleFromUserById(userId, roleId);
            }
        }

        for (String role: curr){
            if (!pre.contains(role)){
                int roleId = roleService.queryRoleByName(role).getId();
                userRoleMapper.addRoleToUserById(userId, roleId);
            }
        }
    }

}
