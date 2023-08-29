package com.hong.basic_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;


@ConfigurationPropertiesScan
@SpringBootApplication
public class BasicBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicBoardApplication.class, args);
    }

}
