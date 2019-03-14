package com.nju.readlatermessagepush;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ReadlaterMessagepushApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadlaterMessagepushApplication.class, args);
    }

}

