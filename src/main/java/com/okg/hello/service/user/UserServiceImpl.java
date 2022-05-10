package com.okg.hello.service.user;

import com.okg.hello.dao.entity.dataobject.UserDO;
import com.okg.hello.dao.entity.CommonResponse;
import com.okg.hello.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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
        return CommonResponse.success(userMapper.selectById(id));
    }

    @Override
    public CommonResponse queryAllUsers() {
        return CommonResponse.success(userMapper.selectAll());
    }

    @Transactional
    @Override
    public CommonResponse login(UserDO userDO) {
        // 数据合法性判断
        if (userDO == null || userDO.getUserName() == null || userDO.getUserName().isEmpty() || userDO.getPassword() == null || userDO.getPassword().isEmpty()) {
            return CommonResponse.response(10000, "账号或密码不能为空");
        }
        // 查看用户是否存在
        List<UserDO> userDOList = userMapper.selectByUserName(userDO.getUserName());
        if (userDOList == null || userDOList.isEmpty()) {
            // 用户不存在
            return CommonResponse.response(10001, "用户不存在，请先注册");
        }
        // 取第一个用户
        UserDO resultUserDO = userDOList.get(0);
        // 判断密码是否正确
        if (!userDO.getPassword().equals(resultUserDO.getPassword())) {
            // 密码不正确
            return CommonResponse.response(10002, "密码错误，请输入正确密码！");
        }
        // 登录成功
        return CommonResponse.success("登录成功", resultUserDO);
    }

    @Transactional
    @Override
    public CommonResponse register(UserDO userDO) {
        // 数据合法性判断
        if (userDO == null || userDO.getUserName() == null || userDO.getUserName().isEmpty() || userDO.getPassword() == null || userDO.getPassword().isEmpty()) {
            return CommonResponse.response(10000, "账号或密码不能为空");
        }
        // 查看用户是否存在(已被注册)
        List<UserDO> userDOList = userMapper.selectByUserName(userDO.getUserName());
        if (userDOList != null && !userDOList.isEmpty()) {
            // 用户已存在
            return CommonResponse.response(10001, "该用户名称已存在，请换一个名称");
        }
        // 插入数据库
        userMapper.addUser(userDO);
        return CommonResponse.success("注册成功");
    }

    @Transactional
    @Override
    public CommonResponse deleteUser(int id) {
        userMapper.deleteById(id);
        return CommonResponse.success(null);
    }
}
