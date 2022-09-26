package fr.isika.al17.urbanisationsi.microservices_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
	
@SpringBootApplication
@EnableFeignClients("fr.isika.al17.urbanisationsi.microservices_client")
@EnableDiscoveryClient
public class MicroservicesClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroservicesClientApplication.class, args);
    }
}