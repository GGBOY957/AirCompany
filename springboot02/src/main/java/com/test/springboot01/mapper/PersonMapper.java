package com.test.springboot01.mapper;

import com.test.springboot01.bean.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("select * from person")
    public List<Person> getAllPersons();

    @Select("select * from person where id=#{id}")
    public Person getPersonById(Integer id);

    @Delete("delete from person where id=#{id}")
    public int delPersonById(Integer id);

    @Update("update person set lastname=#{lastname},boss=#{boss},birth=#{birth} where id=#{id}")
    public int UpdatePerson(Person person);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into person(lastname,boss,birth) values (#{lastname},#{boss},#{birth})")
    public int InsertPerson(Person person);

}
