package fr.isika.al17.urbanisationsi.microservices_product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private String productLabel;

    private Long productNumber;

    public Product() {
	super();
    }

    public Product(Integer id, String productLabel, Long productNumber) {
	super();
	this.id = id;
	this.productLabel = productLabel;
	this.productNumber = productNumber;
    }

    public String getProductLabel() {
	return productLabel;
    }

    public void setProductLabel(String productLabel) {
	this.productLabel = productLabel;
    }

    public Long getProductNumber() {
	return productNumber;
    }

    public void setProductNumber(Long productNumber) {
	this.productNumber = productNumber;
    }

    public Integer getId() {
	return id;
    }

}
