package fr.isika.al17.urbanisationsi.microservices_client.beans;

public class ContractBean {

    private Integer id;
    private Long contractNumber;
    private String startDate;
    private Long insuredNumber;
    private Long productNumber;

    public ContractBean() {
	super();
    }

    public ContractBean(Integer id, Long contractNumber, String startDate, Long insuredNumber, Long productNumber) {
	super();
	this.id = id;
	this.contractNumber = contractNumber;
	this.startDate = startDate;
	this.insuredNumber = insuredNumber;
	this.productNumber = productNumber;
    }

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public Long getContractNumber() {
	return contractNumber;
    }

    public void setContractNumber(Long contractNumber) {
	this.contractNumber = contractNumber;
    }

    public String getStartDate() {
	return startDate;
    }

    public void setStartDate(String startDate) {
	this.startDate = startDate;
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

    @Override
    public String toString() {
	return "ContractBean [id=" + id + ", contractNumber=" + contractNumber + ", startDate=" + startDate
		+ ", insuredNumber=" + insuredNumber + ", productNumber=" + productNumber + "]";
    }

}
