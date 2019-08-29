package com.test.springboot01.mapper;

import com.test.springboot01.bean.Dog;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from dog where id=#{id}")
    public Dog getDeptById(Integer id);

    @Delete("delete from dog where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into dog(name) values(#{name})")
    public int insertDept(Dog dog);

    @Update("update dog set name=#{name} where id=#{id}")
    public int updateDept(Dog dog);
}
