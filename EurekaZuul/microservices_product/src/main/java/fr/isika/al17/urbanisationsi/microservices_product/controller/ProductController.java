package fr.isika.al17.urbanisationsi.microservices_product.controller;

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

import fr.isika.al17.urbanisationsi.microservices_product.dao.ProductRepository;
import fr.isika.al17.urbanisationsi.microservices_product.model.Product;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/addProduct")
    public ResponseEntity<Void> createProduct(@RequestBody Product product) {
	Product addedProduct = productRepository.save(product);

	if (addedProduct == null)
	    return ResponseEntity.noContent().build();

	URI uri = ServletUriComponentsBuilder
		.fromCurrentRequest().path("/{id}")
		.buildAndExpand(addedProduct.getId())
		.toUri();
	return ResponseEntity.created(uri).build();
    }
    
    @GetMapping(path = "/listProduct")
    public @ResponseBody Iterable<Product> getAllProducts(){
	return productRepository.findAll();
    }

    @DeleteMapping(path = "/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id) {
	productRepository.deleteById(id);
    }

    @PutMapping(path = "/updateProduct")
    public void updateProduct(@RequestBody Product product) {
	productRepository.save(product);
    }
    
    @GetMapping(path = "/productNumber/{productNumber}")
    public List<Product> findByProductNumber(@PathVariable Long productNumber){
	return productRepository.findByProductNumber(productNumber);
    }
    
    @GetMapping(path = "/productLabel/{productLabel}")
    public List<Product> findByProductLabel(@PathVariable String productLabel){
	return productRepository.findByProductLabel(productLabel);
    }


}
