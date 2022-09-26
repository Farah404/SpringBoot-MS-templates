package fr.isika.al17.tp_gateway_security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.isika.al17.tp_gateway_security.dao.RoleRepository;
import fr.isika.al17.tp_gateway_security.model.Role;

@SpringBootApplication
public class TpGatewaySecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpGatewaySecurityApplication.class, args);
	}

	  @Bean
	    CommandLineRunner init(RoleRepository roleRepository) {

	        return args -> {

	            Role adminRole = roleRepository.findByRole("ADMIN");
	            if (adminRole == null) {
	                Role newAdminRole = new Role();
	                newAdminRole.setRole("ADMIN");
	                roleRepository.save(newAdminRole);
	            }

	            Role userRole = roleRepository.findByRole("USER");
	            if (userRole == null) {
	                Role newUserRole = new Role();
	                newUserRole.setRole("USER");
	                roleRepository.save(newUserRole);
	            }
	        };

	    }

	}
