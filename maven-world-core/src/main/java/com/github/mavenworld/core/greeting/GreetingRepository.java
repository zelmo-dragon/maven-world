package com.github.mavenworld.core.greeting;

import java.util.HashSet;
import java.util.Set;

/**
 * Repository for {@link GreetingMessage}.
 */
public interface GreetingRepository {

    /**
     * Save a new entity.
     *
     * @param entity New entity
     * @return The value {@code true} if the new entity is added
     */
    boolean add(GreetingMessage entity);

    /**
     * Remove all registered entity.
     */
    void clear();

    /**
     * Get the number of entity registered.
     *
     * @return The number of entity registered
     */
    int size();

    /**
     * Internal in memory implementation.
     */
    class InMemory implements GreetingRepository {

        /**
         * In memory database.
         */
        private final Set<GreetingMessage> database;

        /**
         * Default constructor.
         */
        public InMemory() {
            this.database = new HashSet<>();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean add(GreetingMessage entity) {
            return this.database.add(entity);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void clear() {
            this.database.clear();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int size() {
            return this.database.size();
        }


    }
}
