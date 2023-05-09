package com.bytedance.juejin.basic.boot.i18n;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * i18n basename
 */
public class MessageSourceBasename {

    /**
     * 获得所有的 basename
     * <p>
     * resources/i18n/{basename}_(en_US/zh_CN).properties
     */
    @SneakyThrows
    public static String[] get(ApplicationContext context) {
        Set<String> basenames = new HashSet<>();
        Resource[] resources = context.getResources("classpath*:i18n/**");
        for (Resource resource : resources) {
            String filename = resource.getFilename();
            if (filename == null) {
                continue;
            }
            String basename;
            int indexOf = filename.indexOf("_");
            if (indexOf == -1) {
                basename = filename;
            } else {
                basename = filename.substring(0, indexOf);
            }
            basenames.add("i18n/" + basename);
        }
        return basenames.toArray(new String[0]);
    }
}
