package com.okg.hello.service.user;

import com.okg.hello.dao.entity.User;
import com.okg.hello.dao.entity.CommonResponse;
import com.okg.hello.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 业务层：登录服务实现类，处理登录业务逻辑
 * 对用户表进行增删查改
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public CommonResponse queryUser(int id) {
        return CommonResponse.success(userMapper.queryUserById(id));
    }

    @Override
    public CommonResponse queryAllUsers() {
        return CommonResponse.success(userMapper.queryAllUsers());
    }

    @Transactional
    @Override
    public CommonResponse login(User user) {
        // 数据合法性判断
        if (user == null || user.getUserName() == null || user.getUserName().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
            return CommonResponse.response(10000, "账号或密码不能为空");
        }
        // 查看用户是否存在
        User existUser = userMapper.queryUserByName(user.getUserName());
        if (existUser == null) {
            // 用户不存在
            return CommonResponse.response(10001, "用户不存在，请先注册");
        }
        // 判断密码是否正确
        if (!user.getPassword().equals(existUser.getPassword())) {
            // 密码不正确
            return CommonResponse.response(10002, "密码错误，请输入正确密码！");
        }
        // 登录成功
        return CommonResponse.success("登录成功", existUser);
    }

    @Transactional
    @Override
    public CommonResponse register(User user) {
        // 数据合法性判断
        if (user == null || user.getUserName() == null || user.getUserName().isEmpty() || user.getPassword() == null || user.getPassword().isEmpty()) {
            return CommonResponse.response(10000, "账号或密码不能为空");
        }
        // 查看用户是否存在(已被注册)
        User existUser = userMapper.queryUserByName(user.getUserName());
        if (existUser != null) {
            // 用户已存在
            return CommonResponse.response(10001, "该用户名称已存在，请换一个名称");
        }
        // 插入数据库
        try {
            userMapper.addUser(user);
            return CommonResponse.success("注册成功");
        } catch (Exception e) {
            return CommonResponse.response(10002, "系统异常，请联系系统管理员");
        }
    }

    @Transactional
    @Override
    public CommonResponse deleteUser(int id) {
        userMapper.deleteUser(id);
        return CommonResponse.success(null);
    }
}
