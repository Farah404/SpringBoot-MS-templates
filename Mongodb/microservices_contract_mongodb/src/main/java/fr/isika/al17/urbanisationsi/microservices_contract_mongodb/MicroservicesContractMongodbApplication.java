package fr.isika.al17.urbanisationsi.microservices_contract_mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MicroservicesContractMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesContractMongodbApplication.class, args);
	}

}
