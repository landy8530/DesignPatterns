package org.landy.web.config;

import org.landy.web.utils.ApplicationUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 相当于Spring.xml配置文件的作用
 * @author landyl
 * @create 2:44 PM 09/30/2018
 */
@Configuration
//@EnableLoadTimeWeaving(aspectjWeaving = EnableLoadTimeWeaving.AspectJWeaving.ENABLED)
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.landy")
public class ApplicationConfigure {

    @Bean
    public ApplicationUtil getApplicationUtil() {
        return new ApplicationUtil();
    }

}
