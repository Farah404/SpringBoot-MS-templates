package fr.isika.al17.urbanisationsi.microservices_insured.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component    
@ConfigurationProperties("urbanisationsi.clairprev") 
public class ApplicationPropertiesConfiguration {
	     private int limitedInsuredNumber;

	    public int getlimitedInsuredNumber() {
	        return limitedInsuredNumber;
	    }

	    public void setlimitedInsuredNumber(int limitedInsuredNumber) {
	        this.limitedInsuredNumber = limitedInsuredNumber;
	    }

}
