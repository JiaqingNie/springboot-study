package com.nie.mapper;

import com.nie.pojo.Operation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OperationMapper {

    @Select("select * from operation where op_name = #{opName}")
    @Results( id = "operationMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "opName", column = "op_name")
    })
    Operation queryOpByName(String opName);

    @Select("select * from operation where id = #{id}")
    @ResultMap(value = {"operationMap"})
    Operation queryOpById(int id);

    @Select("select * from operation order by id")
    @ResultMap(value = {"operationMap"})
    List<Operation> queryOpList();

    @Insert("insert into operation (op_name) values (opName)")
    int createOp(Operation op);

    @Update("update operation set op_name = #{opName} where id = #{id}")
    int updateOp(Operation op);

    @Delete("delete from operation where id = #{id}")
    int deleteOp(int id);


}
