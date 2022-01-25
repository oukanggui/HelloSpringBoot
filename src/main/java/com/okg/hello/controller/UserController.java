package com.okg.hello.controller;

import com.okg.hello.dao.entity.User;
import com.okg.hello.dao.entity.CommonResponse;
import com.okg.hello.service.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 控制层：对外接入的用户Controller控制层
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping(value = "/getUserList")
    public CommonResponse getUserList() {
        log.info("getUserList");
        return userService.queryAllUsers();
    }

    /**
     * 根据ID获取用户信息
     *
     * @return
     */
    @GetMapping(value = "/getUserInfo")
    public CommonResponse getUserInfo(@RequestParam("id") Integer id) {
        log.info("getUserInfo，id = {}", id);
        return userService.queryUser(id);
    }

    /**
     * 登录
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public CommonResponse login(User user) {
        log.info("login：{}", user.toString());
        return userService.login(user);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/register")
    public CommonResponse register(User user) {
        log.info("register：{}", user.toString());
        return userService.register(user);
    }


    /**
     * 删除用户信息
     */
    @GetMapping(value = "/delete")
    public CommonResponse deleteUser(@RequestParam("id") Integer id) {
        log.info("deleteUser，id = {}", id);
        userService.deleteUser(id);
        return CommonResponse.successResponse(null);
    }


}
