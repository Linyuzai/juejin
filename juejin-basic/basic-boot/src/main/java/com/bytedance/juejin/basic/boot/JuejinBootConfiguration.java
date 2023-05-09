package com.bytedance.juejin.basic.boot;

import com.bytedance.juejin.basic.boot.i18n.I18nWebResultFactory;
import com.bytedance.juejin.basic.boot.i18n.MessageSourceBasename;
import com.github.linyuzai.cloud.web.core.result.WebResultFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * 单体应用配置
 */
@Configuration
public class JuejinBootConfiguration {

    /**
     * i18n
     */
    @Bean
    public MessageSource messageSource(ApplicationContext context) {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames(MessageSourceBasename.get(context));
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * i18n处理了失败信息的返回值工厂
     */
    @Bean
    public WebResultFactory webResultFactory() {
        return new I18nWebResultFactory();
    }
}
