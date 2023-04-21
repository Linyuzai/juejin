package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.i18n.I18nWebResultFactory;
import com.bytedance.juejin.basic.i18n.MessageSourceBasename;
import com.github.linyuzai.cloud.web.core.result.WebResultFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;


/**
 * 单体应用和微服务都需要注入的组件
 */
@Configuration
public class JuejinBasicConfiguration {

    @Bean
    public MessageSource messageSource(ApplicationContext context) {
        //Locale.setDefault(Locale.CHINESE);
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(MessageSourceBasename.get(context));
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public WebResultFactory webResultFactory() {
        return new I18nWebResultFactory();
    }
}
