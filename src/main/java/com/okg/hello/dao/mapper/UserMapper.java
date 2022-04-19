package com.okg.hello.dao.mapper;

import com.okg.hello.dao.entity.dataobject.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 数据层,数据库操作mapper接口
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
    List<UserDO> selectAll();

    /**
     * 通过用户id查询User对象
     */
    List<UserDO> selectById(int id);

    /**
     * 根据用户名查找用户信息
     */
    List<UserDO> selectByUserName(String userName);

    /**
     * 添加用户
     */
    int addUser(UserDO userDO);

    /**
     * 删除用户
     */
    void deleteById(int id);


}
