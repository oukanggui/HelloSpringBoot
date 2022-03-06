package com.okg.hello.controller;

import com.okg.hello.dao.entity.User;
import com.okg.hello.dao.entity.CommonResponse;
import com.okg.hello.service.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制层：对外接入的用户Controller控制层
 * SpringBoot之接收参数的常用注解
 *
 * @RequestParam：url的请求参数,如果参数变量名保持一致，该注解可以省略
 * @PathVariable：路径请求参数
 * @RequestBody：请求体Body参数（一般是实体Bean参数或Map对象，用于Post请求），如果用于实体类，该注解可以省略
 * @RequestHeader：请求头参数
 * @CookiesValue：cookies参数
 */
@Slf4j
@RestController // @ResponseBody+@Controller的结合注解
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping(value = "getUserList")
    public CommonResponse getUserList() {
        log.info("getUserList");
        return userService.queryAllUsers();
    }

    /**
     * 根据ID获取用户信息
     * 如果变量名与参数名一致，@RequestParam可以不加字符串描述，如“id”,也可以省略使用RequestParam注解
     *
     * @return
     */
    @GetMapping(value = "getUserInfo")
    public CommonResponse getUserInfo(@RequestParam("id") Integer id) {
        log.info("getUserInfo，id = {}", id);
        return userService.queryUser(id);
    }

    /**
     * 删除用户信息
     * 这里分别用过@RequestHeader和@CookiesValue注解分别获取请求头参数和cookies参数
     */
    @GetMapping(value = "delete")
    public CommonResponse deleteUser(@RequestParam("id") Integer id,
                                     @RequestHeader("token") String token,
                                     @CookieValue("clientId") String clientId,
                                     HttpServletRequest request) {
        log.info("deleteUser，id = {}，token = {}，clientId = {}", id, token, clientId);
//        String headerToken = request.getHeader("token"); 或者通过request获取请求头
        userService.deleteUser(id);
        return CommonResponse.success(null);
    }

    /**
     * 登录
     * Post请求接收实体类参数时，可以省略@RequestBody参数
     *
     * @param user
     * @return
     */
    @PostMapping(value = "login")
    public CommonResponse login(@RequestBody User user) {
        log.info("login：{}", user.toString());
        return userService.login(user);
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @PostMapping(value = "register")
    public CommonResponse register(User user) {
        log.info("register：{}", user.toString());
        return userService.register(user);
    }

}
