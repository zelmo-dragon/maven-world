package com.github.mavenworld.core.greeting;

import java.util.Objects;

/**
 * Business service for greeting.
 */
public class GreetingService {

    /**
     * @see GreetingRepository
     */
    private final GreetingRepository greetingRepository;

    /**
     * Construct the service with its dependencies.
     *
     * @param greetingRepository The repository for {@link GreetingMessage}
     */
    public GreetingService(final GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    /**
     * Add a new greeting message.
     *
     * @param greetingMessage The greeting message
     * @return The value {@code true} if the message is registered, otherwise {@code false}
     */
    public boolean addGreetingMessage(final GreetingMessage greetingMessage) {
        validate(greetingMessage);
        return this.greetingRepository.add(greetingMessage);
    }

    /**
     * Validate a {@link GreetingMessage}.
     *
     * @param entity The entity to validate
     * @throws GreetingException The exception if the entity has an invalid message
     */
    private static void validate(final GreetingMessage entity) {
        Objects.requireNonNull(entity, "GreetingMessage can not be null");
        Objects.requireNonNull(entity.message(), "Message can not be null");
        if (entity.message().isBlank()) {
            throw new GreetingException("Message can not be blank");
        }
    }

}
