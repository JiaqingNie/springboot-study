package com.nie.controller;

import com.nie.pojo.User;
import com.nie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.queryUserByUsername(username);
    }

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.queryUserList();
    }

    // json提交
    @PostMapping("/users")
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // json提交
    @PatchMapping("/users/{id}")
    public int updateUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public int deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
