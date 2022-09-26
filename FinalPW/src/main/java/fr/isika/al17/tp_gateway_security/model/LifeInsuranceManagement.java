package fr.isika.al17.tp_gateway_security.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"id","email"})
@ToString(of= {"id","email","password", "fullName", "active"})
@Document(collection = "lifeinsurancedb")
public class LifeInsuranceManagement {
    
    @Id
    private String id;
    
    @Indexed(unique=true, direction=IndexDirection.DESCENDING)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String fullName;
    @NotNull
    private boolean active;
    
    @DBRef
    private Set<Role> roles;

    public LifeInsuranceManagement() {
	super();
    }

    public LifeInsuranceManagement(String id, String email, @NotNull String password, @NotNull String fullName,
	    @NotNull boolean active, Set<Role> roles) {
	super();
	this.id = id;
	this.email = email;
	this.password = password;
	this.fullName = fullName;
	this.active = active;
	this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getId() {
        return id;
    }
    
    
    
    

}
