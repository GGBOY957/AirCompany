package org.jeff.springmvc.mapper;


import org.jeff.springmvc.po.User;

public interface UserMapper {
/*
*@描述 添加用户
* @param user
* @throws Exception
* */

    boolean insertUser(User user) throws Exception;

}
