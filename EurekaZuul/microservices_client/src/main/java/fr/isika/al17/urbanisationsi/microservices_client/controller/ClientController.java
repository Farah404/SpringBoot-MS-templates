package fr.isika.al17.urbanisationsi.microservices_client.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.isika.al17.urbanisationsi.microservices_client.beans.ContractBean;
import fr.isika.al17.urbanisationsi.microservices_client.beans.InsuredBean;
import fr.isika.al17.urbanisationsi.microservices_client.beans.ProductBean;
import fr.isika.al17.urbanisationsi.microservices_client.proxies.MicroserviceContractProxy;
import fr.isika.al17.urbanisationsi.microservices_client.proxies.MicroserviceInsuredProxy;
import fr.isika.al17.urbanisationsi.microservices_client.proxies.MicroserviceProductProxy;

@Controller
public class ClientController {

    @Autowired
    private MicroserviceInsuredProxy mInsuredProxy;

    @Autowired
    private MicroserviceContractProxy mContractProxy;
    
    @Autowired
    private MicroserviceProductProxy mProductProxy;

    
    Logger log = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/")
    
    public String welcome(Model model){
        log.info("---------------------------- sending request to welcome");

        InsuredBean insuredBean = new InsuredBean();
        model.addAttribute("insuredBean", insuredBean);
        //J4 - 10
        return "Accueil";
    }

    @GetMapping(path="/insured/insuredNumber/{insuredNumber}")
    public String findInsuredByInsuredNumber(@PathVariable Long insuredNumber, Model model) {
        List<InsuredBean> insuredList = mInsuredProxy.findInsuredByInsuredNumber(insuredNumber);
        model.addAttribute("insuredList", insuredList);
        return "InsuredDetails";
    }

    @PostMapping(value = "/input-Insured")
    public String inputInsured(InsuredBean insuredBean, Model model){
        log.info("---------------------------- sending request to inputInsured");
        List<InsuredBean> insuredList =  mInsuredProxy.findInsuredByLastnameAndFirstname(insuredBean.getLastname(), insuredBean.getFirstname());
        model.addAttribute("insuredList", insuredList);
        return "InsuredList";
    }
    
    @GetMapping(path="/create/{insuredNumber}")
    public String create(@PathVariable Long insuredNumber, Model model) {
        ContractBean contractBean = mContractProxy.create(insuredNumber);
        model.addAttribute("contractBean", contractBean);
        List<ProductBean> products = mProductProxy.listAllProducts();
        model.addAttribute("products", products);
        return "ProductList";
    }
    
    @GetMapping(path="/createContract/{insuredNumber}")
    public String createContract(@PathVariable Long insuredNumber, Model model) {
        ContractBean contractBean = new ContractBean();
        contractBean.setId(12345);
        contractBean.setStartDate("2000-01-01");
        contractBean.setContractNumber(543L);
        contractBean.setProductNumber(123L);
        contractBean.setInsuredNumber(insuredNumber);
        log.info("---------------------------- sending request to createContract");
        mContractProxy.createContract(contractBean);
        model.addAttribute("contractBean", contractBean);
        List<ProductBean> products = mProductProxy.listAllProducts();
        model.addAttribute("products", products);
        return "ProductList";
    }
    
    @GetMapping(path="/defineProductNumber/{insuredNumber}/{productNumber}")
    public String defineProductNumber(@PathVariable Long insuredNumber, @PathVariable Long productNumber, Model model) {
        log.info("-----------------ClientController > defineProductNumber > insuredNumber : " + insuredNumber + " productNumber : " + productNumber);
        ContractBean definedContract = mContractProxy.defineProductNumber(insuredNumber, productNumber);
        log.info("-----------------ClientController > defineProductNumber > mContractProxy.defineProductNumber : " + definedContract);
        model.addAttribute("definedContract", definedContract);
        return "FinaliseContract";
    }
    
    @GetMapping(path = "/finaliseContract/{definedContract}")
    public String finaliseContract(@PathVariable Long insuredNumber, ContractBean definedContract, Model model) {
        log.info("-----------------ClientController > finaliseContract > definedContract : " + definedContract);
        ContractBean finalisedContract =  mContractProxy.finaliseContract(insuredNumber, definedContract.getContractNumber(), definedContract.getStartDate());
        log.info("-----------------ClientController > finaliseContract > mContractProxy.finaliseContract : " + finalisedContract);
        model.addAttribute("finalisedContract", finalisedContract);
        return "ContractCreationConfirmation";
    }
}