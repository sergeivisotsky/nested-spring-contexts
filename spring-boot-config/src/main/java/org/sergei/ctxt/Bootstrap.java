package org.sergei.ctxt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Main class to start an application with multiple application contexts bumped up.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
public final class Bootstrap {

    private static final Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    private Bootstrap() {
        // noon
    }

    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        PathMatchingResourcePatternResolver defaultResourceLoader = new PathMatchingResourcePatternResolver(classLoader);

        SpringApplication application = new SpringApplication(defaultResourceLoader, DefaultConfiguration.class);
        application.setRegisterShutdownHook(false);
        application.setWebApplicationType(WebApplicationType.NONE);

        ConfigurableApplicationContext ctxt = application.run(args);
        ctxt.getBeansOfType(BootstrapBean.class)
                .values()
                .stream()
                .sorted(AnnotationAwareOrderComparator.INSTANCE)
                .forEach(bootstrap -> {
                    LOG.info("~~~ Starting up a bootstrap bean: {} ~~~", bootstrap.getIdentifier().getName());
                    bootstrap.start();
                });
    }
}
