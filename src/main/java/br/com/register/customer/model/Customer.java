package br.com.register.customer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="customer")
public class Customer {
	
	@Id
	private Long id;
	private String name;
	private int age;

}
