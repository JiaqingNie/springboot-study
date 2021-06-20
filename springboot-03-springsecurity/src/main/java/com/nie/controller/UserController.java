package com.nie.controller;

import com.nie.pojo.User;
import com.nie.service.RoleService;
import com.nie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 通过用户名检索用户
     * @param username 用户名
     * @return
     */
    @GetMapping("/users/{username}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_USER_READ')")
    public User getUserByUsername(@PathVariable("username") String username){
        return userService.queryUserByUsername(username);
    }

    /**
     * 获取用户列表
     * @param model spring ui model
     * @return 用户列表页面
     */
    @GetMapping("/users")
    @PreAuthorize("hasAuthority('OP_USER_READ')")
    public String getUserList(Model model){
        List<User> users = userService.queryUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    /**
     * 获取修改用户的页面
     * @param id 用户ID
     * @param model spring ui model
     * @return 用户编辑页面
     */
    @GetMapping("/users/{id}/edit")
    @PreAuthorize("hasAuthority('OP_USER_UPDATE')")
    public String getEditPage(@PathVariable("id") int id, Model model){
        User user = userService.queryUserById(id);
        List<String> roleStringList = roleService.queryRoleStringList();
        model.addAttribute("user", user);
        model.addAttribute("roles", roleStringList);
        return "user/edit";
    }

    /**
     * 获取创建新用户的页面
     * @param model spring ui model
     * @return 用户创建页面
     */
    @GetMapping("/users/new")
    @PreAuthorize("hasAuthority('OP_USER_CREATE')")
    public String getNewPage(Model model){
        List<String> roleStringList = roleService.queryRoleStringList();
        model.addAttribute("roles", roleStringList);
        return "/user/new";
    }

    /**
     * 创建新的用户
     * @param user 需要被创建的用户
     * @return 服务层返回的代码（1 表示成功）
     */
    //
    @PostMapping("/users")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_USER_CREATE')")
    public int createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    /**
     * 修改用户
     * @param id 用户ID
     * @param user 被修改的用户
     * @return 服务层返回的代码（1 表示成功）
     */
    @PatchMapping("/users/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_USER_UPDATE')")
    public int updateUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(user);
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 服务层返回的代码（1 表示成功）
     */
    @DeleteMapping("/users/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_USER_DELETE')")
    public int deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
