package com.ypy.springbootinactiontwentythree.twentyfourtest.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public Integer addUser(String userName){
        System.out.println("userName :" + userName);
        if (userName == null) {
            return 0;
        }
        return  1;
    }

}
