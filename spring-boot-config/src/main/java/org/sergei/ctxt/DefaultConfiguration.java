package org.sergei.ctxt;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.Resource;

/**
 * Default configuration.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Configuration
public class DefaultConfiguration {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig(@Value("classpath*:META-INF/config/*-default.properties") Resource[] defaults,
                                                                      @Value("classpath*:META-INF/config/*-override.properties") Resource[] overrides,
                                                                      @Value("file:${CONFIG_PATH}/*.properties") Resource[] envConfigs,
                                                                      @Value("classpath:local.properties") Resource local) {

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setIgnoreResourceNotFound(true);
        configurer.setLocations(ArrayUtils.addAll((ArrayUtils.add(ArrayUtils.addAll(defaults, overrides), local)), envConfigs));
        return configurer;
    }
}
