package com.okg.hello.service.user;

import com.okg.hello.entity.User;
import com.okg.hello.entity.common.CommonResponse;

/**
 * 登录业务层用户操作接口
 */
public interface IUserService {
    CommonResponse queryUserById(int id);
    CommonResponse queryAllUsers();
    CommonResponse deleteUser(int id);
    CommonResponse login(User user);
    CommonResponse register(User user);
}
