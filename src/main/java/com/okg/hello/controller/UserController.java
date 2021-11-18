package com.okg.hello.controller;

import com.okg.hello.entity.User;
import com.okg.hello.entity.common.CommonResponse;
import com.okg.hello.service.user.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层：对外接入的用户Controller控制层
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    // 日志输出
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping(value = "/getUserList")
    public CommonResponse getUserList() {
        logger.info("getUserList");
        return CommonResponse.successResponse(userService.queryAllUsers());
    }

    /**
     * 根据ID获取用户信息
     *
     * @return
     */
    @GetMapping(value = "/getUserInfo")
    public CommonResponse getUserInfo(@RequestParam("id") Integer id) {
        logger.info("getUserInfo，id = {}", id);
        return CommonResponse.successResponse(userService.queryUserById(id));
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/add")
    public CommonResponse addUser(User user) {
        logger.info("addUser：{}", user.toString());
        return CommonResponse.successResponse(userService.addUser(user));
    }


    /**
     * 删除用户信息
     */
    @GetMapping(value = "/delete")
    public CommonResponse deleteUser(@RequestParam("id") Integer id) {
        logger.info("deleteUser，id = {}", id);
        userService.deleteUser(id);
        return CommonResponse.successResponse(null);
    }


}
