package com.github.mavenworld.core.greeting.test;

import com.github.mavenworld.core.greeting.GreetingException;
import com.github.mavenworld.core.greeting.GreetingMessage;
import com.github.mavenworld.core.greeting.GreetingRepository;
import com.github.mavenworld.core.greeting.GreetingService;
import org.junit.jupiter.api.*;

class GreetingServiceTest {

    static GreetingRepository repository;

    static GreetingService underTest;

    GreetingServiceTest() {
    }

    @BeforeAll
    static void setUp() {
        repository = new GreetingRepository.InMemory();
        underTest = new GreetingService(repository);
    }

    @AfterAll
    static void tearDown() {
        // NO-OP
    }

    @BeforeEach
    void init() {
        // NO-OP
    }

    @AfterEach
    void dispose() {
        repository.clear();
    }

    @Test
    void shouldAddGreetingMessage() {
        var greetingMessage = new GreetingMessage("Hello world");
        var added = underTest.addGreetingMessage(greetingMessage);

        Assertions.assertTrue(added);
    }

    @Test
    void shouldNotAddDuplicateGreetingMessage() {
        var greetingMessage0 = new GreetingMessage("Hello world");
        var added0 = underTest.addGreetingMessage(greetingMessage0);

        var greetingMessage1 = new GreetingMessage("Hello world");
        var added1 = underTest.addGreetingMessage(greetingMessage1);

        var count = repository.size();

        Assertions.assertTrue(added0);
        Assertions.assertFalse(added1);
        Assertions.assertEquals(1, count);
    }

    @Test
    void shouldThrowExceptionForNullEntity() {
        Assertions.assertThrowsExactly(
                NullPointerException.class,
                () -> underTest.addGreetingMessage(null)
        );
    }

    @Test
    void shouldThrowExceptionForNullMessage() {
        Assertions.assertThrowsExactly(
                NullPointerException.class,
                () -> underTest.addGreetingMessage(new GreetingMessage(null))
        );
    }

    @Test
    void shouldThrowExceptionForBlackMessage() {
        Assertions.assertThrowsExactly(
                GreetingException.class,
                () -> underTest.addGreetingMessage(new GreetingMessage("   "))
        );
    }

}
