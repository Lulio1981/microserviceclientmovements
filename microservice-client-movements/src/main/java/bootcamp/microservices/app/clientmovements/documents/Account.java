package bootcamp.microservices.app.clientmovements.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class Account implements Serializable {

	private static final long serialVersionUID = -2192062026580323624L;

	private String id;

	private String accountNumber;

	private String interbankAccountNumber;

	private String idAccountType;

	private String idClient;

	private Double minimumBalance;

	private Integer operationsNumber;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;

	private String createUser;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifyDate;

	private String modifyUser;
}
