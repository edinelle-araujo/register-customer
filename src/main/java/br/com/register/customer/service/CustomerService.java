package br.com.register.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.register.customer.model.Customer;
import br.com.register.customer.repository.CustomerRepository;
import lombok.extern.java.Log;

@Service
@Log
public class CustomerService {	
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	public void save(Customer customer) {
		customerRepository.save(customer);
		log.info("customer saved successfully");
	}
	
	public void remove(Long id){
		customerRepository.deleteById(id);
		log.info("customer removed successfully");
	}
	
	public List<Customer> list(){
		return customerRepository.findAll();
	}
	
	public Customer listById(Long id){
		Customer customer = null;
		Optional<Customer> opptionalCustomer = customerRepository.findById(id);
		if (opptionalCustomer.isPresent()) {
			log.info("customer found successfully with id: " + id);
			customer = opptionalCustomer.get();
		}
		return customer;
	}
	
	public Customer update(Customer customer) {
		Customer customerUpdated = null;
		Optional<Customer> opptionalClient = customerRepository.findById(customer.getId());
		if (opptionalClient.isPresent()) {
			log.info("customer found successfully with id: " + customer.getId());
			customerUpdated = customerRepository.save(customer);
		}

		return customerUpdated;
	}


}
