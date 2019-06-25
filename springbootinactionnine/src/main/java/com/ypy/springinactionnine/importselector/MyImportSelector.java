package com.ypy.springinactionnine.importselector;

import com.ypy.springinactionnine.myannotation.EnableLog;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {

    /**
     * ImportSelector的说明：
     *
     * （1）方法的返回值，必须是一个class全路径；
     * （2）该class会被spring容器托管起来，注入到容器中成为一个Bean!
     * （3）如果class是一个配置类，那么该配置类中所定义的Bean都会被注入到容器中！
     *
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        /**
         * 这里可以获取注解的详细信息！
         * 然后根据注解的详细信息，返回需要被spring容器管理的Bean！
         */
        System.out.println(annotationMetadata.getAllAnnotationAttributes(EnableLog.class.getName()));

        return new String[]{
                "com.ypy.springinactionnine.importannotation.User",
                "com.ypy.springinactionnine.importannotation.Role",
                "com.ypy.springinactionnine.importannotation.MyConfiguration"
        };
    }
}
