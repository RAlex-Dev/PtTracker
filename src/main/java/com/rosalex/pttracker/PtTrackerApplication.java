package com.rosalex.pttracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class PtTrackerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PtTrackerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PtTrackerApplication.class, args);
    }

    private static Class <PtTrackerApplication> applicationClass = PtTrackerApplication.class;

}
