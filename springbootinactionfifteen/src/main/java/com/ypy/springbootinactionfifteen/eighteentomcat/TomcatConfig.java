package com.ypy.springbootinactionfifteen.eighteentomcat;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

/**
 * 知识点2：使用编码的方式优化Tomcat
 * Tomcat优化配置类
 */
@SpringBootConfiguration
public class TomcatConfig {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
        tomcatFactory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
        /*tomcatFactory.setPort(8080);
        tomcatFactory.setContextPath("/");*/
        return tomcatFactory;
    }

    class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {
        public void customize(Connector connector) {
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            /**
             * 设置最大连接数
             * 这个参数是指在同一时间，tomcat能够接受的最大连接数。
             * 一般这个值要大于maxThreads+acceptCount
             */
            protocol.setMaxConnections(10000);
            /**
             * 设置最大线程数
             * 每一次HTTP请求到达Web服务，tomcat都会创建一个线程来处理该请求，
             * 那么最大线程数决定了Web服务可以同时处理多少个请求，默认200
             *
             * 注意:
             * (1)增加线程是有成本的，JVM中默认情况下在创建新线程时会分配大小为1M的线程栈，所以更多的线程异味着更多的内存
             * (2)更多的线程会带来更多的线程上下文切换成本
             */
            protocol.setMaxThreads(2000);
            /**
             * 最大等待数
             * 当调用Web服务的HTTP请求数达到tomcat的最大线程数时，
             * 还有新的HTTP请求到来，这时tomcat会将该请求放在等待队列中，
             * 这个acceptCount就是指能够接受的最大等待数，默认100.
             * 如果等待队列也被放满了，这个时候再来新的请求就会被tomcat拒绝（connection refused）
             */
            protocol.setAcceptCount(2000);
            protocol.setConnectionTimeout(30000);
        }
    }

}
