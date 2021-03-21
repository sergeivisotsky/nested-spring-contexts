package org.sergei.ctxt.firstapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Springs {@link Configuration} for the first application.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Configuration
public class FirstAppConfiguration {

    @Bean
    public FirstAppBootstrap firstAppBootstrap() {
        return new FirstAppBootstrap();
    }
}
