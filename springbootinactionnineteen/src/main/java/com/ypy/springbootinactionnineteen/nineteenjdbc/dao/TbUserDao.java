package com.ypy.springbootinactionnineteen.nineteenjdbc.dao;


import com.ypy.springbootinactionnineteen.nineteenjdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class TbUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(User user){
        String sql = "INSERT into tb_user (user_id,  username, mobile) VALUES ('"+ user.getUserId()+"','"+user.getUsername()+"','"+user.getMobile()+"');";
        jdbcTemplate.execute(sql);
    }

    @Transactional(rollbackFor = Exception.class)
    public void batchAddUser(List<User> userList){
        for (int i=0;i<userList.size();i++) {
            User user = userList.get(i);
            String sql = "INSERT into tb_user (user_id,  username, mobile) VALUES ('"+ user.getUserId()+"','"+user.getUsername()+"','"+user.getMobile()+"');";
            jdbcTemplate.execute(sql);
        }

        throw new RuntimeException("主动抛出异常！");
    }

    /**
     * 包裹事物：
     * （1）注意：默认只对RuntimeException起作用，进行回滚
     * （2）rollbackFor = Exception.class,可以设置对那些异常进行回滚！
     * （3）noRollbackFor = XXX,可以设置对那些异常进行不回滚！
     */
    @Transactional(rollbackFor = Exception.class)
    public void batchAddUser1(List<User> userList){
        batchAddUser(userList);
    }

}
