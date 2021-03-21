package org.sergei.ctxt;

/**
 * BootstrapBean which should be initialized inside a spring context.
 * Is a runnable bootstrap bean by itself.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
public interface BootstrapBean {

    void start();

    default BootstrapIdentifier getIdentifier() {
        return () -> getClass().getSimpleName();
    }
}
