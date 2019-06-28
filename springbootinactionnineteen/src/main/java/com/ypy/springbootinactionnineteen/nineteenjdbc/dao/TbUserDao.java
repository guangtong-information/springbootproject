package com.ypy.springbootinactionnineteen.nineteenjdbc.dao;


import com.ypy.springbootinactionnineteen.nineteenjdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TbUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user){
        String sql = "INSERT into tb_user (user_id,  username, mobile) VALUES ('"+ user.getUserId()+"','"+user.getUsername()+"','"+user.getMobile()+"');";
        jdbcTemplate.execute(sql);
    }

}
