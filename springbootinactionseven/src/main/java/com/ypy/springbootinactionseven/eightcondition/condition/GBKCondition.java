package com.ypy.springbootinactionseven.eightcondition.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 实现Condition接口，提供@Condition注解调用
 */
public class GBKCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        // 获取当前文件编码
        String encoding = System.getProperty("file.encoding");
        if (encoding != null) {
            return "gkb".equals(encoding.toLowerCase());
        }
        return false;
    }
}
