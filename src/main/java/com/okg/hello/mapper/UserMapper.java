package com.okg.hello.mapper;

import com.okg.hello.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据层
 * 用户表对应的mapper
 * 指定这是一个操作数据库的mapper，完成用户数据库相关操作
 */
@Mapper
public interface UserMapper {

    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from tb_user")
    List<User> queryAllUsers();

    /**
     * 通过用户id查询User对象
     */
    @Select("select * from tb_user where id = #{id}")
    User queryUserById(int id);

    /**
     * 根据用户名查找用户信息
     */
    @Select("select * from tb_user where userName = #{userName}")
    User queryUserByName(String userName);

    /**
     * 添加用户
     */
    //options用来定义主键返回,keyProperty指定主键对应的属性
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into tb_user(userName,password) values (#{userName} , #{password})")
    int addUser(User user);

    /**
     * 删除用户
     */
    @Delete("delete from tb_user where id = #{id}")
    void deleteUser(int id);


}
