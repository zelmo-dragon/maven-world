module mavenworld.core.test {

    requires mavenworld.core;

    requires transitive org.junit.jupiter.api;
    requires transitive org.junit.jupiter.engine;

    opens com.github.mavenworld.core.greeting.test to org.junit.platform.commons;
}