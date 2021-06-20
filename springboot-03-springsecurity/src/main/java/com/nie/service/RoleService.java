package com.nie.service;

import com.nie.pojo.Role;

import java.util.List;

public interface RoleService {

    Role queryRoleByName(String roleName);

    Role queryRoleById(int id);

    List<Role> queryRoleList();

    List<String> queryRoleStringList();

    int createRole(Role role);

    int updateRole(Role role);

    int deleteRole(int id);
}
