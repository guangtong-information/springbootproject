package com.ypy.springbootinactionnineteen.twentytwolog.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    public void log(){
        logger.info("info");
        logger.debug("debug");
        logger.warn("warn");
        logger.error("error");
    }
}
