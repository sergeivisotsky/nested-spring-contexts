package org.sergei.ctxt.firstapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Springs {@link Configuration} for the second application.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Configuration
public class SecondAppConfiguration {

    @Bean
    public SecondAppBootstrap firstAppBootstrap() {
        return new SecondAppBootstrap();
    }
}
