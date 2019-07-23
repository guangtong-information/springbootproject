package com.ypy.mallweb;

import com.google.gson.Gson;
import com.ypy.mallweb.bean.Response;
import com.ypy.mallweb.loadbalance.LoadBalance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 知识点3：zk当有多个服务的时候，客户端模拟一个负载均衡
 */
public class App3 {

    public static void main(String[] args) throws Exception {

        // 第一步：链接到zk
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("127.0.0.1:2181",new RetryOneTime(1000));
        curatorFramework.start();
        // 先启动，直到链接上为止
        curatorFramework.blockUntilConnected();

        // 第二步：服务发现，根据节点名称，获取节点的详细信息
        ServiceDiscovery serviceDiscovery = ServiceDiscoveryBuilder.builder(Object.class).client(curatorFramework).basePath("/soa").build();
        // 获取服务端所有的服务
        Collection<ServiceInstance> list = serviceDiscovery.queryForInstances("product");
        List<String> services = new ArrayList<>();
        list.forEach(serviceInstance -> {
            services.add(serviceInstance.getAddress()+":"+serviceInstance.getPort());
        });

        // 第三步：调用模拟的负载均衡器
        LoadBalance loadBalance = new LoadBalance(services);
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(loadBalance.choose());
        String body = restTemplate.getForObject("http://" + loadBalance.choose() + "/get/1",String.class);
        Response response = new Gson().fromJson(body,Response.class);
        System.out.println(response);
    }

}
