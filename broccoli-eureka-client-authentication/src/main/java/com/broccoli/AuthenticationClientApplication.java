package com.broccoli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthenticationClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthenticationClientApplication.class, args);
    }
}
