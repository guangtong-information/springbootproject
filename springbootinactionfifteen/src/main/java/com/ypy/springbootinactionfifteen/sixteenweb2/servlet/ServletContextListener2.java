package com.ypy.springbootinactionfifteen.sixteenweb2.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListener2 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("--------contextInitialized---------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("--------contextDestroyed---------");
    }
}
