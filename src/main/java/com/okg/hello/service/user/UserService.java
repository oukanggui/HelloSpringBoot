package com.okg.hello.service.user;

import com.okg.hello.dao.entity.User;
import com.okg.hello.dao.entity.CommonResponse;

/**
 * 登录业务层用户操作接口
 */
public interface UserService {
    CommonResponse queryUser(int id);
    CommonResponse queryAllUsers();
    CommonResponse deleteUser(int id);
    CommonResponse login(User user);
    CommonResponse register(User user);
}
