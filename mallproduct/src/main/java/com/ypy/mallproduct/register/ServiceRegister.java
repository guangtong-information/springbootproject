package com.ypy.mallproduct.register;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 讲服务注册到zookeeper
 * 【注意】：ApplicationRunner是容器生命周期的方法，说明当容器启动的时候，在执行run方法！实现服务的注册！
 */
@Component
public class ServiceRegister implements ApplicationRunner {

    // 从配置文件中获取配置项
    @Value("${zookeeper.address}")
    private String zookeeperAddress;

    @Value("${server.port}")
    private int serverPort;

    @Value("${server.address}")
    private String address;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 第一步：链接到zk
        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperAddress,new RetryOneTime(1000));
        client.start();
        // 先启动，知道链接上为止
        client.blockUntilConnected();

        // 第二步：服务注册到zk
        // 定义一个服务，节点名称为product
        // 查看节点 ls /soa/product
        ServiceInstance serviceInstance = ServiceInstance.builder().name("product").address(address).port(serverPort).build();

        // 定义一个服务发现者，必须制定默认的根节点，根节点名称为soa
        ServiceDiscovery serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class).client(client).basePath("/soa").build();

        // 将服务注册到服务发现者（创建节点）
        serviceDiscovery.registerService(serviceInstance);
        serviceDiscovery.start();

        System.out.printf("------------------服务注册成功！------------------");

    }
}
