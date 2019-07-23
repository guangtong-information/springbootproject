package com.ypy.mallweb;

import com.google.gson.Gson;
import com.ypy.mallweb.bean.Response;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

/**
 * 知识点2：服务的注册和发现，从Zookeeper节点中发现服务
 * （1）在进度服务调用的时候，需要从注册中心获取地址，然后在发起调用。
 *
 * 注意：真实环境会缓存注册中心的地址，而不会像现在这样每次都调用一次zookeeper
 */
public class App2 {

    public static void main(String[] args) throws Exception {

        // 第一步：连接到zk
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1:2181",new RetryOneTime(1000));
        curatorFramework.start();
        // 先启动，知道链接上为止
        curatorFramework.blockUntilConnected();

        // 第二步：服务发现，根据节点名称，获取节点的详细数据
        ServiceDiscovery serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class).client(curatorFramework).basePath("/soa").build();
        Collection<ServiceInstance> list = serviceDiscovery.queryForInstances("product");
        System.out.println("list:" + list);
        list.forEach(serviceInstance -> {
            RestTemplate restTemplate = new RestTemplate();
            String body = restTemplate.getForObject("http://" +serviceInstance.getAddress() + ":" + serviceInstance.getPort() + "/get/1",String.class);
            Response response = new Gson().fromJson(body,Response.class);
            System.out.println(response);
        });
    }

}
