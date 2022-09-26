package fr.isika.al17.urbanisationsi.microservices_client.beans;

import javax.validation.constraints.NotNull;

public class ProductBean {

    @NotNull
    private Long productNumber;
    @NotNull
    private String productLabel;

    public ProductBean() {
	super();
    }

    public ProductBean(@NotNull Long productNumber, @NotNull String productLabel) {
	super();
	this.productNumber = productNumber;
	this.productLabel = productLabel;
    }

    public Long getProductNumber() {
	return productNumber;
    }

    public void setProductNumber(Long productNumber) {
	this.productNumber = productNumber;
    }

    public String getProductLabel() {
	return productLabel;
    }

    public void setProductLabel(String productLabel) {
	this.productLabel = productLabel;
    }

}
