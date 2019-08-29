package com.test.springboot01.service;

import com.test.springboot01.bean.Person;
import com.test.springboot01.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;

    public List<Person> personList(){
        return personMapper.getAllPersons();
    }

    public int insert(Person person){
        return  personMapper.InsertPerson(person);
    }

    public int delete(Integer id){
        return personMapper.delPersonById(id);
    }

    public int update(Person person){
        return personMapper.UpdatePerson(person);
    }

    public Person getById(Integer id){
        return personMapper.getPersonById(id);
    }
}
