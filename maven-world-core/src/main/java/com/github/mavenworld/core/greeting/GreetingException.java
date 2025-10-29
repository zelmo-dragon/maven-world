package com.github.mavenworld.core.greeting;

import java.io.Serial;

/**
 * Business exception for greeting.
 */
public class GreetingException extends RuntimeException {

    /**
     * Serial number.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Construct an exception with message.
     *
     * @param message Exception message
     */
    GreetingException(final String message) {
        super(message);
    }
}
