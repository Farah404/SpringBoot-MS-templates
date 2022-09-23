package fr.isika.al17.urbanisationsi.microservices_product.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.isika.al17.urbanisationsi.microservices_product.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
    
    List<Product> findByProductNumber (Long productNumber);
    List<Product> findByProductLabel (String productLabel); 

}
