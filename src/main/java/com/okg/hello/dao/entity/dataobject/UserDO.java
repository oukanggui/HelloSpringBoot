package com.okg.hello.dao.entity.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 用户数据库实体对象，与数据库user表的映射
 */
@Data    // 自动生成getter和setter方法
@ToString // 自动生成toString方法
@NoArgsConstructor // 自动生成无参数的默认构造方法
@AllArgsConstructor // 自动生成全参数构造方法
public class UserDO {
    private Integer id;
    private String userName;
    private String password;
}
