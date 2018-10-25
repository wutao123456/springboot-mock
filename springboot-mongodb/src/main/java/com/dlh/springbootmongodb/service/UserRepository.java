package com.dlh.springbootmongodb.service;

import com.dlh.springbootmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * create by wutao on 2018/10/25
 */
public interface UserRepository extends MongoRepository<User,Long> {

    User findUserByName(String name);

}
