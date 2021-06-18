package com.nie.controller;

import com.nie.pojo.Role;
import com.nie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles/{roleName}")
    public Role getRoleByName(@PathVariable("roleName") String roleName){
        return roleService.queryRoleByName(roleName);
    }

    @GetMapping("/roles")
    public List<Role> getRoleList(){
        return roleService.queryRoleList();
    }

    // json提交
    @PostMapping("/roles")
    public int createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    // json提交
    @PatchMapping("/roles/{id}")
    public int updateRole(@PathVariable("id") int id, @RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping("/roles/{id}")
    public int deleteRole(@PathVariable("id") int id){
        return roleService.deleteRole(id);
    }

}
