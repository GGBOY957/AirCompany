package com.test.springboot01.mapper;


import com.test.springboot01.bean.Limits;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LimitsMapper {

    @Select("select * from limits where id=#{id}")
    public Limits getLimitsById(Integer id);

    @Delete("delete from limits where id=#{id}")
    public int delLimitsById(Integer id);

    @Update("update limits set id=#{id},l1=#{l1},l2=#{l2},l3=#{l3},l4=#{l4} where id=#{id}")
    public int updateLimits(Limits limits);

    @Insert("insert into limits(id,l1,l2,l3,l4) values (#{id},#{l1},#{l2},#{l3},#{l4})")
    public int insertLimits(Limits limits);
}
