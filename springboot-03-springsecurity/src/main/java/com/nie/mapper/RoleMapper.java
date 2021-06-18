package com.nie.mapper;

import com.nie.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RoleMapper {

    Role queryRoleByName(String roleName);

    Role queryRoleById(int id);

    List<Role> queryRoleList();

    int createRole(Role role);

    int updateRole(Role role);

    int deleteRole(int id);
}
