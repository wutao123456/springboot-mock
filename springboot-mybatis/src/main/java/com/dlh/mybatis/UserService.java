package com.dlh.mybatis;

import com.dlh.mybatis.dao.UserMapper;
import com.dlh.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author wutao
 * @email wutao56789@gmail.com
 * @date 2018/10/27 0:19
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * value存的是key的集合(zset),key存的是user对象
     * @param id
     * @return
     */
    @Cacheable(value = "selectOne",key = "'users_'+#id")
    public User selectOne(int id){
        System.err.println("打印语句没有走缓存");
        return userMapper.selectOne(id);
    }
}
