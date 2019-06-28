package com.ypy.springbootinactionnineteen.nineteenjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 知识点1：环境的搭建，springboot数据库连接池的使用
 * （1）POM文件加入数据库连接池的依赖
 *         <dependency>
 *             <groupId>org.springframework.boot</groupId>
 *             <artifactId>spring-boot-starter-jdbc</artifactId>
 *         </dependency>
 *
 *         <dependency>
 *             <groupId>mysql</groupId>
 *             <artifactId>mysql-connector-java</artifactId>
 *         </dependency>
 *
 * （2）在application.properties中配置数据库连接池
 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
 * #spring.datasource.url=jdbc:mysql://127.0.0.1:3306/demo_test1?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=GMT%2B8
 * spring.datasource.url=jdbc:mysql://127.0.0.1:3306/demo_test1
 * spring.datasource.username=root
 * spring.datasource.password=root
 *
 * （3）springboot会自动装配数据库连接池，默认使用HikariDataSource数据库连接池
 * （4）可以在配置文件中指定使用哪种数据库连接池
 * 第一步：添加依赖
 *         <dependency>
 *             <groupId>com.zaxxer</groupId>
 *             <artifactId>HikariCP</artifactId>
 *         </dependency>
 *
 *         <dependency>
 *             <groupId>org.apache.tomcat</groupId>
 *             <artifactId>tomcat-jdbc</artifactId>
 *         </dependency>
 * 第二步：添加配置
 * #指定数据库源
 * #spring.datasource.type=com.zaxxer.hikari.HikariDataSource
 * spring.datasource.type=org.apache.tomcat.jdbc.pool.DataSource
 *
 * （5）springboot默认支持5种数据库连接池
 * DataSourceConfiguration.Hikari.class,
 * DataSourceConfiguration.Tomcat.class,
 * DataSourceConfiguration.Dbcp2.class,
 * DataSourceConfiguration.Generic.class,
 * DataSourceJmxConfiguration.class
 *
 * （6）使用第三方的数据库连接池
 * 第一步：导入依赖
 * <dependency>
 * <groupId>com.alibaba</groupId>
 * <artifactId>druid</artifactId>
 * <version>1.1.16</version>
 * </dependency>
 * 第二步：在配置文件启用连接池
 *
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws SQLException {
        SpringApplication springApplication = new SpringApplication(App.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);

        // springboot自动装配数据库连接池,默认使用HikariDataSource数据库连接池
        DataSource dataSource = configurableApplicationContext.getBean(DataSource.class);
        System.out.println("dataSource:" + dataSource.toString());

        Connection connection = dataSource.getConnection();
        System.out.println("catalog:" + connection.getCatalog());
        connection.close();
    }

}
