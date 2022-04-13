package com.okg.hello.service.user;

import com.okg.hello.dao.entity.UserDO;
import com.okg.hello.dao.entity.CommonResponse;

/**
 * 登录业务层用户操作接口
 */
public interface UserService {
    /**
     * 根据用户id查询用户信息
     *
     * @param id
     * @return
     */
    CommonResponse queryUser(int id);

    /**
     * 获取所有用户信息
     *
     * @return
     */
    CommonResponse queryAllUsers();

    /**
     * 根据id（主键）删除用户
     *
     * @param id
     * @return
     */
    CommonResponse deleteUser(int id);

    /**
     * 用户登录
     *
     * @param userDO
     * @return
     */
    CommonResponse login(UserDO userDO);

    /**
     * 用户注册
     *
     * @param userDO
     * @return
     */
    CommonResponse register(UserDO userDO);
}
