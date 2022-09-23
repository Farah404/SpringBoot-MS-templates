package fr.isika.al17.urbanisationsi.server_configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer   
public class ServerConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerConfigurationApplication.class, args);
	}

}
