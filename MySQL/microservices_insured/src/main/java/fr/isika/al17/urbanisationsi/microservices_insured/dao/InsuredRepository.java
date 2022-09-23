package fr.isika.al17.urbanisationsi.microservices_insured.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.al17.urbanisationsi.microservices_insured.model.Insured;

public interface InsuredRepository extends CrudRepository<Insured, Integer>{
    
    List<Insured> findByPersonNumber (Long personNumber);

}
