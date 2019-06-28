package com.ypy.springbootinactionnineteen.nineteenjdbc.datasourceconfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 不使用自动装配DataSource，代码方式自定义数据库连接池相关参数
 * 代码的方式注入DruidDataSource
 * 注意：不写配置类也可以，springboot会自动注入
 */
//@SpringBootConfiguration
public class DataSourceConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource createDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(environment.getProperty("spring.datasource.url"));
        druidDataSource.setUsername(environment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(environment.getProperty("spring.datasource.password"));
        druidDataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
        return druidDataSource;
    }

}
