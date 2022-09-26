package fr.isika.al17.tp_gateway_security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.isika.al17.tp_gateway_security.model.Role;

public interface RoleRepository extends MongoRepository<Role, String>{

    Role findByRole(String role);
}
