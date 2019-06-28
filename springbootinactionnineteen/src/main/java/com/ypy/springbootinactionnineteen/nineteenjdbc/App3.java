package com.ypy.springbootinactionnineteen.nineteenjdbc;

import com.ypy.springbootinactionnineteen.nineteenjdbc.dao.TbUserDao;
import com.ypy.springbootinactionnineteen.nineteenjdbc.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * 知识点3：开启事物的支持
 * （1）启动事物 @EnableTransactionManagement
 * （2）在方法上开启事物 @Transactional
 *      默认只对RuntimeException起作用，进行回滚
 *      rollbackFor=Exception.class，可以设置对那些异常回滚
 *      noRollBackFor=XXX，可以设置对那些异常不回滚
 * （3）注意：@Transaction注解设置的方法一定要是public、private不会生效
 * （4）注意：没有设置@Transactional注解的方法，去调用设置了@Transactional的方法，事物不会生效！
 *            如果要生效，必须2个方法都设置@Transactional注解！
 *            或者，首先被调用的方法，增加@Transactional注解，第二个被调用的方法，可以不设置Transactional注解！
 * （5）Transactional注解可以放在类上，这样改类下面的所有方法，都将被事物包裹！（不推荐这样做，推荐在需要的方法上增加事物）
 *
 */
@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionnineteen.nineteenjdbc.dao"})
public class App3 {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App3.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUserId(10);
        user.setUsername("10");
        user.setMobile("13333333333");

        User user1 = new User();
        user1.setUserId(11);
        user1.setUsername("11");
        user1.setMobile("13333333333");
        users.add(user);
        users.add(user1);
        configurableApplicationContext.getBean(TbUserDao.class).batchAddUser1(users);
    }

}
