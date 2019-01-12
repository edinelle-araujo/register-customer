package br.com.register.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.register.customer.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Long>{

}
