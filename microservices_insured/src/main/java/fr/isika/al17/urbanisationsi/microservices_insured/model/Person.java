package fr.isika.al17.urbanisationsi.microservices_insured.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public abstract class Person {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Length(min=3, max=30, message = "Le nombre de caractères du nom de la personne doit être compris entre 3 et 30 au sens large.")
    private String lastname;
    
    private String firstname;
    
    private Long personNumber;
    
    private Date birthDate;

    public Person() {
	super();
    }

    public Person(Integer id, String lastname, String firstname, Long personNumber, Date birthDate) {
	super();
	this.id = id;
	this.lastname = lastname;
	this.firstname = firstname;
	this.personNumber = personNumber;
	this.birthDate = birthDate;
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

    public Long getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(Long personNumber) {
        this.personNumber = personNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }
    
    

}
