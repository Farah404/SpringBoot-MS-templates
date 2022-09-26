package fr.isika.al17.tp_gateway_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.isika.al17.tp_gateway_security.dao.RoleRepository;
import fr.isika.al17.tp_gateway_security.model.Role;

@RestController
@RequestMapping(path="/Role")
public class RoleController {
    
    @Autowired
    RoleRepository roleRepository;
    
    @GetMapping(path="/findByRole/{role}")
    public Role findByRole(@PathVariable String role){
	return roleRepository.findByRole(role);
    }

}
