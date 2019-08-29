package com.test.springboot01.mapper;

import com.test.springboot01.bean.Limits;
import com.test.springboot01.bean.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("select * from users")
    public List<Users> getAllUsers();

    @Select("select * from users where id=#{id}")
    public Users getUsersById(Integer id);

    @Delete("delete from users where id=#{id}")
    public int delUsersById(Integer id);

    @Update("update users set id=#{id},name=#{name},department=#{department},job=#{job},login_time=#{login_time} where id=#{id}")
    public int updateUsers(Users users);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into users(id,name,department,job,login_time) values (#{id},#{name},#{department},#{job},#{login_time})")
    public int insertUsers(Users users);
}
