package org.jeff.springmvc.service;

import org.jeff.springmvc.po.User;

public interface UserService {
    /*
    * @描述 添加用户
    * @param user
    * @throw Exception
    * */
    boolean insertUser(User user) throws  Exception;

}
