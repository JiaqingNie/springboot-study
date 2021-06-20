package com.nie.service.impl;

import com.nie.mapper.RoleMapper;
import com.nie.mapper.RoleOperationMapper;
import com.nie.pojo.Operation;
import com.nie.pojo.Role;
import com.nie.service.OperationService;
import com.nie.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleOperationMapper roleOperationMapper;

    @Autowired
    private OperationService operationService;

    @Override
    public Role queryRoleByName(String roleName) {
        return roleMapper.queryRoleByName(roleName);
    }

    @Override
    public Role queryRoleById(int id) {
        return roleMapper.queryRoleById(id);
    }

    @Override
    public List<Role> queryRoleList() {
        return roleMapper.queryRoleList();
    }

    @Override
    public List<String> queryRoleStringList() {
        List<Role> roleList = queryRoleList();
        List<String> roleStringList = new ArrayList<>();
        for (Role role : roleList) {
            roleStringList.add(role.getRoleName());
        }
        return roleStringList;
    }

    @Override
    public int createRole(Role role) {
        int res = roleMapper.createRole(role);
        int roleId = roleMapper.queryRoleByName(role.getRoleName()).getId();
        for (String op : role.getOperationSet()){
            int opId = operationService.queryOpByName(op).getId();
            roleOperationMapper.addOptoRoleById(roleId, opId);
        }
        return res;
    }

    @Override
    public int updateRole(Role role) {
        int roleId = role.getId();
        Set<String> previousOpSet = roleMapper.queryRoleById(roleId).getOperationSet();
        Set<String> currOpSet = role.getOperationSet();

        updateRoleOps(roleId, previousOpSet, currOpSet);

        return roleMapper.updateRole(role);
    }

    @Override
    public int deleteRole(int id) {
        return roleMapper.deleteRole(id);
    }

    private void updateRoleOps(int roleId, Set<String> pre, Set<String> curr){
        for (String op : pre){
            if (!curr.contains(op)){
                int opId = operationService.queryOpByName(op).getId();
                roleOperationMapper.removeOpFromRoleById(roleId, opId);
            }
        }

        for (String op : curr){
            if (!pre.contains(op)){
                int opId = operationService.queryOpByName(op).getId();
                roleOperationMapper.addOptoRoleById(roleId, opId);
            }
        }
    }
}
