package com.nie.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserRoleMapper {
    int addRoleToUserById(@Param("user_id") int userId, @Param("role_id") int roleId);

    int removeRoleFromUserById(@Param("user_id") int userId, @Param("role_id") int roleId);

}
