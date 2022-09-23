package fr.isika.al17.urbanisationsi.microservices_contract;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MicroservicesContractApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesContractApplication.class, args);
	}

}
