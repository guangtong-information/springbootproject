package com.ypy.springbootinactionfifteen.sixteenweb2.servlet3;


import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("------contextInitialized-----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("------contextDestroyed-----");
    }
}
