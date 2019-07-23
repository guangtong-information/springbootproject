package com.ypy.mallweb.loadbalance;

import java.util.List;

/**
 * 模拟负载均衡器：实现轮询负载的效果
 */
public class LoadBalance {

    private int index = 0;
    private List<String> services;

    public LoadBalance(List<String> services){
        this.services = services;
    }

    public String choose(){
        String service = services.get(index);
        index ++;
        if (index >= services.size()) {
            index = 0;
        }
        return service;
    }
}
