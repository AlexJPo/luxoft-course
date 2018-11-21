package ru.ajp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ajp
 * @date 22.11.2018
 */
@SpringBootApplication
@EnableEurekaClient
public class ClientService {
    public static void main(String[] args) {
        SpringApplication.run(ClientService.class, args);
    }
}
