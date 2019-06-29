package com.ypy.springbootinactionnineteen.twentytwolog.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDao.class);

    public void log(){
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
    }

}
