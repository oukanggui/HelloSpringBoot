package com.okg.hello.service.user;

import com.okg.hello.entity.User;

import java.util.List;

/**
 * 登录业务层用户操作接口
 */
public interface IUserService {
    User queryUserById(int id);
    List<User> queryAllUsers();
    int addUser(User user);
    void deleteUser(int id);
}
