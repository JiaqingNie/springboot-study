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

    /**
     * 通过角色名检索角色
     * @param roleName 角色名
     * @return 该角色名对应的角色
     */
    @GetMapping("/roles/{roleName}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_ROLE_READ')")
    public Role getRoleByName(@PathVariable("roleName") String roleName){
        return roleService.queryRoleByName(roleName);
    }

    /**
     * 获取角色列表
     * @param model spring ui model
     * @return 角色列表页面
     */
    @GetMapping("/roles")
    @PreAuthorize("hasAuthority('OP_ROLE_READ')")
    public String getRoleList(Model model) {
        List<Role> roleList = roleService.queryRoleList();
        model.addAttribute("roles", roleList);
        return "role/list";
    }

    /**
     * 获取编辑角色的页面
     * @param id 角色ID
     * @param model spring ui model
     * @return 角色编辑页面
     */
    @GetMapping("/roles/{id}/edit")
    @PreAuthorize("hasAuthority('OP_ROLE_UPDATE')")
    public String getEditPage(@PathVariable("id") int id, Model model) {
        Role role = roleService.queryRoleById(id);
        List<String> operations = operationService.queryOpStringList();
        model.addAttribute("role", role);
        model.addAttribute("operations", operations);
        return "role/edit";
    }

    /**
     * 获取创建角色的页面
     * @param model spring ui model
     * @return 角色创建页面
     */
    @GetMapping("roles/new")
    @PreAuthorize("hasAuthority('OP_ROLE_CREATE')")
    public String getNewPage(Model model) {
        List<String> operations = operationService.queryOpStringList();
        model.addAttribute("operations", operations);
        return "role/new";
    }

    /**
     * 创建新的角色
     * @param role 要被创建的角色
     * @return 服务层返回的代码（1 表示创建成功）
     */
    @PostMapping("/roles")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_ROLE_CREATE')")
    public int createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    /**
     * 修改角色
     * @param id 角色ID
     * @param role 修改后的角色
     * @return 服务层返回的代码（1 表示修改成功）
     */
    @PatchMapping("/roles/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_ROLE_UPDATE')")
    public int updateRole(@PathVariable("id") int id, @RequestBody Role role){
        return roleService.updateRole(role);
    }

    /**
     * 删除角色
     * @param id 要删除的角色的ID
     * @return 服务层返回的代码（1 表示删除成功）
     */
    @DeleteMapping("/roles/{id}")
    @ResponseBody
    @PreAuthorize("hasAuthority('OP_ROLE_DELETE')")
    public int deleteRole(@PathVariable("id") int id){
        return roleService.deleteRole(id);
    }

}
