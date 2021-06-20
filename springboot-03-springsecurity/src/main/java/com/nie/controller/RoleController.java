package com.nie.controller;

import com.nie.pojo.Role;
import com.nie.service.OperationService;
import com.nie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private OperationService operationService;

    @GetMapping("/roles/{roleName}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_ROLE_READ')")
    public Role getRoleByName(@PathVariable("roleName") String roleName){
        return roleService.queryRoleByName(roleName);
    }

    @GetMapping("/roles")
    @PreAuthorize("hasAuthority('OP_ROLE_READ')")
    public String getRoleList(Model model) {
        List<Role> roleList = roleService.queryRoleList();
        model.addAttribute("roles", roleList);
        return "role/list";
    }

    @GetMapping("/roles/{id}/edit")
    @PreAuthorize("hasAuthority('OP_ROLE_UPDATE')")
    public String getEditPage(@PathVariable("id") int id, Model model) {
        Role role = roleService.queryRoleById(id);
        List<String> operations = operationService.queryOpStringList();
        model.addAttribute("role", role);
        model.addAttribute("operations", operations);
        return "role/edit";
    }

    @GetMapping("roles/new")
    @PreAuthorize("hasAuthority('OP_ROLE_CREATE')")
    public String getNewPage(Model model) {
        List<String> operations = operationService.queryOpStringList();
        model.addAttribute("operations", operations);
        return "role/new";
    }

    // json提交
    @PostMapping("/roles")
    @PreAuthorize("hasAuthority('OP_ROLE_CREATE')")
    public int createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    // json提交
    @PatchMapping("/roles/{id}")
    @PreAuthorize("hasAuthority('OP_ROLE_UPDATE')")
    public int updateRole(@PathVariable("id") int id, @RequestBody Role role){
        return roleService.updateRole(role);
    }

    @DeleteMapping("/roles/{id}")
    @PreAuthorize("hasAuthority('OP_ROLE_DELETE')")
    public int deleteRole(@PathVariable("id") int id){
        return roleService.deleteRole(id);
    }

}
