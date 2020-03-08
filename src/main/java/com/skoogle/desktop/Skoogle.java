package com.skoogle.desktop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author alanterriaga
 * @project skoogle-desktop
 */
@SpringBootApplication
public class Skoogle extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Skoogle.class, args);
    }
}
