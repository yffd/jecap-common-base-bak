package com.yffd.jecap.admin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AdminApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
