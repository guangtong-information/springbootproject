package com.ypy.springbootinactionnineteen.nineteenjdbc;

import com.ypy.springbootinactionnineteen.nineteenjdbc.dao.TbUserDao;
import com.ypy.springbootinactionnineteen.nineteenjdbc.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 知识点2：使用JdbcTemplate对象
 * SpringBoot会想自动封装DataSource一样，自动封装JdbcTemplate
 */
@SpringBootApplication(scanBasePackages = {"com.ypy.springbootinactionnineteen.nineteenjdbc.dao"})
public class App2 {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App2.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        User user = new User();
        user.setUserId(18);
        user.setUsername("18");
        user.setMobile("13333333333");
        configurableApplicationContext.getBean(TbUserDao.class).addUser(user);
    }
}
