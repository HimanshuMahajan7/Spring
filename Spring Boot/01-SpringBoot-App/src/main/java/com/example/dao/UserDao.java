package com.example.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public UserDao() {
        System.out.println("UserDao :: Constructor");
    }
}
