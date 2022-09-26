package fr.isika.al17.urbanisationsi.microservices_client.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.isika.al17.urbanisationsi.microservices_client.beans.InsuredBean;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-insured")
public interface MicroserviceInsuredProxy {

  @GetMapping(path="/microservice-insured/insured/insuredList")
  List<InsuredBean> getAllInsured();

  @GetMapping(path="/microservice-insured/insured/insuredNumber/{insuredNumber}")
  public List<InsuredBean> findInsuredByInsuredNumber(@PathVariable Long insuredNumber);

  @GetMapping(path="/microservice-insured/insured/insuredByNameFirstname/{name}/{firstname}")
  List<InsuredBean> findInsuredByLastAndFirstname(@PathVariable String name, @PathVariable String firstname);
} 