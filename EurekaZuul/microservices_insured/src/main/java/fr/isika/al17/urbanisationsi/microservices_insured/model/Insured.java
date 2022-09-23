package fr.isika.al17.urbanisationsi.microservices_insured.model;

import javax.persistence.Entity;

@Entity
public class Insured extends Person {

    private String medicalFolder;

    private Long insuredNumber;

    public Insured() {
	super();
    }

    public Insured(String medicalFolder, Long insuredNumber) {
	super();
	this.medicalFolder = medicalFolder;
	this.insuredNumber = insuredNumber;
    }

    public String getMedicalFolder() {
	return medicalFolder;
    }

    public void setMedicalFolder(String medicalFolder) {
	this.medicalFolder = medicalFolder;
    }

    public Long getInsuredNumber() {
	return insuredNumber;
    }

    public void setInsuredNumber(Long insuredNumber) {
	this.insuredNumber = insuredNumber;
    }

}
