package org.jeff.springmvc.service.imp;

//import org.springframework.beans.factory.annotation.Autowired;

/*
* @描述 用户service接口的实现类
*
* */
import org.jeff.springmvc.po.User;
import org.jeff.springmvc.mapper.UserMapper;
import org.jeff.springmvc.service.UserService;

public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

//    @Override
    public boolean insertUser(User user) throws Exception{
        return userMapper.insertUser(user);
    }

}
