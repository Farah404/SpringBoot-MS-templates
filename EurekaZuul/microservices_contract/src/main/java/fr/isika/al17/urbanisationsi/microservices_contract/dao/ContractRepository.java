package fr.isika.al17.urbanisationsi.microservices_contract.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.al17.urbanisationsi.microservices_contract.model.Contract;

public interface ContractRepository extends CrudRepository<Contract, Integer>{
    
    List<Contract> findByContractNumber (Long contractNumber);
    
    List<Contract> findByInsuredNumber (Long insuredNumber);
    
    List<Contract> findByProductNumber (Long productNumber);

}
