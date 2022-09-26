package fr.isika.al17.urbanisationsi.microservices_client.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import fr.isika.al17.urbanisationsi.microservices_client.beans.ContractBean;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-contract")
public interface MicroserviceContractProxy {
    
    @GetMapping(path = "/microservice-contract/contract/getInsuredByContractNumber/{contractNumber}")
    public List<ContractBean> getInsuredByContractNumber(@PathVariable Long contractNumber);

    @PostMapping(path = "/microservice-contract/contract/createContract")
    public ContractBean createContract(@RequestBody ContractBean contract);

    @PostMapping(path = "/microservice-contract/contract/create")
    public ContractBean create(@RequestBody Long insuredNumber);

    @GetMapping(path = "/microservice-contract/contract/setProductNumber/{insuredNumber}/{productNumber}")
    public ContractBean defineProductNumber(@PathVariable Long insuredNumber, @PathVariable Long productNumber);

    @GetMapping(path = "/microservice-contract/contract/completecontract/{insuredNumber}/{contractNumber}/{startDate}")
    public ContractBean finaliseContract(@PathVariable Long insuredNumber, @PathVariable Long contractNumber,
	    @PathVariable String startDate);
//        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut);
}
