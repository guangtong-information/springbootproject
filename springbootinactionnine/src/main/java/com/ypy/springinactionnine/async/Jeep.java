package com.ypy.springinactionnine.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Jeep implements Runnable {

    @Async
    public void run() {
        try{
            for(int i=1;i<3;i++){
                System.out.println("----------------"+i);
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
