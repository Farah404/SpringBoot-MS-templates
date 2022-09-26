package fr.isika.al17.tp_gateway_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al17.tp_gateway_security.dao.LifeInsuranceManagementRepository;
import fr.isika.al17.tp_gateway_security.model.LifeInsuranceManagement;

@RestController
@RequestMapping(path="/lifeInsuranceManagement")
public class LifeInsuranceManagementController {
    
    @Autowired
    LifeInsuranceManagementRepository lifeInsuranceManagementRepository;
    
    @GetMapping(path="/findByEmail/{email}")
    public LifeInsuranceManagement findByEmail(@PathVariable String email){
	return lifeInsuranceManagementRepository.findByEmail(email);
    }

}
