package com.nie.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleOperationMapper {

    @Insert("insert into role_operation (role_id, operation_id) values (#{roleId}, #{opId})")
    int addOptoRoleById(int roleId, int opId);

    @Delete("delete from role_operation where role_id = #{roleId} and operation_id = #{opId}")
    int removeOpFromRoleById(int roleId, int opId);

}
