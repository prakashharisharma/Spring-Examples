package com.td;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    /**
     * Set to {@code true} to use Hazelcast for distributed session
     * storage. Or, {@code false} to turn off Hazelcast and use the
     * default Tomcat non-distributed implementation.
     *
     * This is a constant rather than a parameter to ensure all
     * instances run with the same setting.
     */
    public static final String USE_HAZELCAST = "true";


    /**
     * Run the application under Spring Boot control.
     *
     * @param args From the command line
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}