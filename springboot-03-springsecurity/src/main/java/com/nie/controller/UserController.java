package com.nie.controller;

import com.nie.pojo.User;
import com.nie.service.RoleService;
import com.nie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/users/{username}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_USER_READ')")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.queryUserByUsername(username);
    }

    @GetMapping("/users")
    @PreAuthorize("hasAuthority('OP_USER_READ')")
    public String getUserList(Model model){
        List<User> users = userService.queryUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @GetMapping("/users/{id}/edit")
    @PreAuthorize("hasAuthority('OP_USER_UPDATE')")
    public String getEditPage(@PathVariable("id") int id, Model model){
        User user = userService.queryUserById(id);
        List<String> roleStringList = roleService.queryRoleStringList();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleStringList);
        return "user/edit";
    }

    @GetMapping("/users/new")
    @PreAuthorize("hasAuthority('OP_USER_CREATE')")
    public String getNewPage(){
        return "/user/new";
    }

    // json提交
    @PostMapping("/users")
    @PreAuthorize("hasAuthority('OP_USER_CREATE')")
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // json提交
    @PatchMapping("/users/{id}")
    @PreAuthorize("hasAuthority('OP_USER_UPDATE')")
    public int updateUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    @PreAuthorize("hasAuthority('OP_USER_DELETE')")
    public int deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
