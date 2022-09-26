package fr.isika.al17.urbanisationsi.microservices_client.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InsuredBean {

    private String lastname;
    
    private String firstname;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDate;
    
    private Long insuredNumber;
    
    private String medicalFolder;

    public InsuredBean() {
	super();
    }

    public InsuredBean(String lastname, String firstname, Date birthDate, Long insuredNumber, String medicalFolder) {
	super();
	this.lastname = lastname;
	this.firstname = firstname;
	this.birthDate = birthDate;
	this.insuredNumber = insuredNumber;
	this.medicalFolder = medicalFolder;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getInsuredNumber() {
        return insuredNumber;
    }

    public void setInsuredNumber(Long insuredNumber) {
        this.insuredNumber = insuredNumber;
    }

    public String getMedicalFolder() {
        return medicalFolder;
    }

    public void setMedicalFolder(String medicalFolder) {
        this.medicalFolder = medicalFolder;
    }

    @Override
    public String toString() {
	return "InsuredBean [lastname=" + lastname + ", firstname=" + firstname + ", birthDate=" + birthDate
		+ ", insuredNumber=" + insuredNumber + ", medicalFolder=" + medicalFolder + "]";
    }

}
