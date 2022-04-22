package bootcamp.microservices.app.clientmovements.documents;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Document
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private String documentNumber;

	private String name;

	private String lastName;

	private Integer age;

	private String email;

	private String profile;

	private Integer address;

	private String phoneNumber;

	private String mobilePhone;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date createDate;

	private String createUser;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date modifyDate;

	private String modifyUser;
}
