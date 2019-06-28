package com.ypy.springbootinactionnineteen.twentyaop.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {

    public void add(String username, String password){
        System.out.println("username:,"+username+" password:"+password);
    }

}
