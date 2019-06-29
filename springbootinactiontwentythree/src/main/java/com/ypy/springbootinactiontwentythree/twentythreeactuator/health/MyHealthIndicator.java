package com.ypy.springbootinactiontwentythree.twentythreeactuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 自定义健康状态检查
 */
@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        // 模拟返回健康状态为down
        return Health.down().withDetail("error","sprin boot error").build();
    }
}
