package org.deiv.binarysort.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "org.deiv.binarysort.service",
        "org.deiv.binarysort.config",
        "org.deiv.binarysort.error"})
public class App {

    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext appCtx)
    {
        return args -> {

        };
    }

}
