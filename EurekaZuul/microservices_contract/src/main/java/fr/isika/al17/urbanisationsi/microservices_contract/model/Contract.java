package fr.isika.al17.urbanisationsi.microservices_contract.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contract {

    @Id
    @GeneratedValue
    private Integer id;

    private Date startDate;

    private Long contractNumber;

    private Long insuredNumber;

    private Long productNumber;

    public Contract() {
	super();
    }

    public Contract(Integer id, Date startDate, Long contractNumber, Long insuredNumber, Long productNumber) {
	super();
	this.id = id;
	this.startDate = startDate;
	this.contractNumber = contractNumber;
	this.insuredNumber = insuredNumber;
	this.productNumber = productNumber;
    }

    public Date getStartDate() {
	return startDate;
    }

    public void setStartDate(Date startDate) {
	this.startDate = startDate;
    }

    public Long getContractNumber() {
	return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
	this.contractNumber = contractNumber;
    }

    public Long getInsuredNumber() {
	return insuredNumber;
    }

    public void setInsuredNumber(Long insuredNumber) {
	this.insuredNumber = insuredNumber;
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
