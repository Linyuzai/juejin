package com.bytedance.juejin.basic.name;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.lang.NonNull;

public class JuejinBeanNameGenerator extends AnnotationBeanNameGenerator {

    @Override
    @NonNull
    public String generateBeanName(@NonNull BeanDefinition definition, @NonNull BeanDefinitionRegistry registry) {
        String beanName = super.generateBeanName(definition, registry);
        //System.out.println(beanName);
        String beanClassName = definition.getBeanClassName();
        String juejin = "com.bytedance.juejin";
        if (beanClassName != null && beanClassName.startsWith(juejin)) {
            String[] split = beanClassName.split("\\.");
            if (split.length > 3) {
                String prefix = split[3];
                return prefix + "_" + beanName;
            }
        }
        return beanName;
    }
}
