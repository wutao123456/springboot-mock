package com.dlh.springbootmongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * create by wutao on 2018/10/25
 */
@Document(collection = "user")
public class User {

    private long id;

    private String name;

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
