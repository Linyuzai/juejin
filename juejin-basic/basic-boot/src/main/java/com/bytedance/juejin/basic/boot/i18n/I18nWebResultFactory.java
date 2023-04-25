package com.bytedance.juejin.basic.boot.i18n;

import com.github.linyuzai.cloud.web.core.context.WebContext;
import com.github.linyuzai.cloud.web.core.result.BooleanWebResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class I18nWebResultFactory extends BooleanWebResultFactory {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected String getSuccessMessage(WebContext context) {
        return super.getSuccessMessage(context);
    }

    @Override
    protected String getFailureMessage(Throwable e, WebContext context) {
        String failureMessage = super.getFailureMessage(e, context);
        return messageSource.getMessage(failureMessage,null, Locale.CHINA);
    }
}
