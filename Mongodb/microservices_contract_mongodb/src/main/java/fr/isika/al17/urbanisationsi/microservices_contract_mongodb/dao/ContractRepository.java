package fr.isika.al17.urbanisationsi.microservices_contract_mongodb.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.isika.al17.urbanisationsi.microservices_contract_mongodb.model.Contract;

public interface ContractRepository extends MongoRepository<Contract, String>{
    
    List<Contract> findByContractNumber (Long contractNumber);
    
    List<Contract> findByInsuredNumber (Long insuredNumber);
    
    List<Contract> findByProductNumber (Long productNumber);

}
