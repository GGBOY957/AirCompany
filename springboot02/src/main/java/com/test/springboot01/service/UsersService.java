package com.test.springboot01.service;

import com.test.springboot01.bean.Users;
import com.test.springboot01.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersMapper usersMapper;

    public List<Users> usersonList(){
        return usersMapper.getAllUsers();
    }

//    public int insert(Person person){
//        return  personMapper.InsertPerson(person);
//    }
//
    public int delete(Integer id){
        return usersMapper.delUsersById(id);
    }
//
//    public int update(Person person){
//        return personMapper.UpdatePerson(person);
//    }
//
//    public Person getById(Integer id){
//        return personMapper.getPersonById(id);
//    }
}
