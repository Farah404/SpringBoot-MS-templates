package fr.isika.al17.tp_gateway_security.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.isika.al17.tp_gateway_security.model.LifeInsuranceManagement;

public interface LifeInsuranceManagementRepository extends MongoRepository<LifeInsuranceManagement, String>{
    
    LifeInsuranceManagement findByEmail(String email);

}
