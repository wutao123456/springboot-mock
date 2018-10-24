package com.dlh.mybatis.dao;

import com.dlh.mybatis.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/24 20:47
 */
public interface UserMapper {

    int addUser(User user);

    User selectOne(@Param("id") int id);

    int deleteUser(@Param("id") int id);
}
