package fr.isika.al17.urbanisationsi.microservices_client.proxies;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.isika.al17.urbanisationsi.microservices_client.beans.ProductBean;

@FeignClient(name = "zuul-server")
@RibbonClient(name = "microservice-product")
public interface MicroserviceProductProxy {
    
    @GetMapping(path = "/microservice-product/product/searchByProductNumber/{productNumber}")
    public ProductBean findByProductNumber(@PathVariable Long productNumber);

    @GetMapping(path = "/microservice-product/product/getAllProducts")
    public List<ProductBean> listAllProducts();
}