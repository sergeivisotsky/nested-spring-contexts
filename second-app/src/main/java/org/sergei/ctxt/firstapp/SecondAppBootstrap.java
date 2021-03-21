package org.sergei.ctxt.firstapp;

import org.sergei.ctxt.BootstrapBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.Banner.Mode.OFF;

/**
 * Second application bootstrap which initializes a Spring context to be bumped up into the common.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
public final class SecondAppBootstrap implements BootstrapBean {

    private static final Logger LOG = LoggerFactory.getLogger(SecondAppBootstrap.class);

    @Autowired
    private ConfigurableApplicationContext parent;

    @Override
    public void start() {
        LOG.info("Creating context for Second App module: {}", SecondAppBootstrap.class.getSimpleName());
        new SpringApplicationBuilder()
                .bannerMode(OFF)
                .web(WebApplicationType.NONE)
                .parent(parent)
                .run();
    }
}
