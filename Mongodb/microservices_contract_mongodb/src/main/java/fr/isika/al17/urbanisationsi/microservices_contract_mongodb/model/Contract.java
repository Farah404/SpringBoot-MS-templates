package fr.isika.al17.urbanisationsi.microservices_contract_mongodb.model;

import java.util.Date;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

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

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id", "contractNunmber" })
@ToString(of = { "id", "contractNumber", "startDate", "insuredNumber", "productNumber" })
@Document(collection = "contract_db")
public class Contract {

    @Id
    private String id;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    
    @NotNull
    @Indexed(unique=true, direction = IndexDirection.DESCENDING)
    private Long contractNumber;

    @NotNull
    private Long insuredNumber;

    @NotNull
    private Long productNumber;

}
