package fr.isika.al17.tp_gateway_security.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
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
@EqualsAndHashCode(of= {"id","role"})
@ToString(of= {"id","role"})
@Document(collection = "lifeinsurancedb")
public class Role {
    
    @Id
    private String id;
    
    @Indexed(unique=true, direction=IndexDirection.DESCENDING)
    private String role;

    public Role() {
	super();
    }

    public Role(String id, String role) {
	super();
	this.id = id;
	this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

}
