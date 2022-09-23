package fr.isika.al17.urbanisationsi.microservices_contract.controller;

import java.net.URI;
import java.util.List;

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

import fr.isika.al17.urbanisationsi.microservices_contract.dao.ContractRepository;
import fr.isika.al17.urbanisationsi.microservices_contract.model.Contract;

@RestController
@RequestMapping(path = "/contract")
public class ContractController {

    @Autowired
    private ContractRepository contractRepository;

    @PostMapping(path = "/addContract")
    public ResponseEntity<Void> createContract(@RequestBody Contract contract) {
	Contract addedContract = contractRepository.save(contract);

	if (addedContract == null)
	    return ResponseEntity.noContent().build();

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addedContract.getId())
		.toUri();
	return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/listContract")
    public @ResponseBody Iterable<Contract> getAllContracts() {
	return contractRepository.findAll();
    }

    @DeleteMapping(path = "/deleteContract/{id}")
    public void deleteContract(@PathVariable Integer id) {
	contractRepository.deleteById(id);
    }

    @PutMapping(path = "/updateContract")
    public void updateContract(@RequestBody Contract contract) {
	contractRepository.save(contract);
    }

    @GetMapping(path = "/Contract/contractNumber/{contractNumber}")
    public List<Contract> findByContractNumber(@PathVariable Long contractNumber) {
	return contractRepository.findByContractNumber(contractNumber);
    }

    @GetMapping(path = "/Contract/insuredNumber/{insuredNumber}")
    public List<Contract> findByInsuredNumber(@PathVariable Long insuredNumber) {
	return contractRepository.findByInsuredNumber(insuredNumber);
    }

    @GetMapping(path = "/Contract/productNumber/{productNumber}")
    public List<Contract> findByProductNumber(@PathVariable Long productNumber) {
	return contractRepository.findByProductNumber(productNumber);
    }

}
