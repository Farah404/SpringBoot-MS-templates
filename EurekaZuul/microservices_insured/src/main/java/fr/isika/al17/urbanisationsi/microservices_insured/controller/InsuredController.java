package fr.isika.al17.urbanisationsi.microservices_insured.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.isika.al17.urbanisationsi.microservices_insured.configuration.ApplicationPropertiesConfiguration;
import fr.isika.al17.urbanisationsi.microservices_insured.dao.InsuredRepository;
import fr.isika.al17.urbanisationsi.microservices_insured.model.Insured;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "API for basic CRUD functions for insured microservices")
@RestController
@RequestMapping(path="/insured")
public class InsuredController {
    
    @Autowired
    InsuredRepository insuredRepository;
    
    @Autowired    
    ApplicationPropertiesConfiguration appProperties; 
    
    @PostMapping(path="/addInsured")
    public ResponseEntity<Void> createInsured(@Valid @RequestBody Insured insured){
	
	Insured addedInsured = insuredRepository.save(insured);
	
	if (addedInsured == null)
	    return ResponseEntity.noContent().build();
	
	URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(addedInsured.getId())
                .toUri();
	
	return ResponseEntity.created(uri).build();
    }
    
    @GetMapping(path="/insuredList")
    public @ResponseBody Iterable<Insured> getAllAssures() {
        return insuredRepository.findAll();
    }
    
    @GetMapping(path="/limitedInsuredList")
    public List<Insured> getAllInsured(){
	Iterable<Insured> insuredIterable = insuredRepository.findAll();
	List insuredList = StreamSupport.stream(insuredIterable.spliterator(),false).collect(Collectors.toList());
	List<Insured> limitedList = insuredList.subList(0, appProperties.getlimitedInsuredNumber());
	return limitedList;
    }
    
    @ApiOperation(value = "Find an insured based on its person number if the later exists")
    @GetMapping(path="insuredList/personNumber/{personNumbe}")
    public List<Insured> findByPersonNumber(@PathVariable Long personNumber){
	return insuredRepository.findByPersonNumber(personNumber);
    }
    
    @DeleteMapping (path="insured/{id}")
    public void deleteInsured(@PathVariable Integer id) {
	insuredRepository.deleteById(id);
    }
    
    @PutMapping (path="/editInsured")
    public void editInsured(@RequestBody Insured insured) {
	insuredRepository.save(insured);
    }

}
