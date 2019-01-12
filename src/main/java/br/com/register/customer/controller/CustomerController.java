package br.com.register.customer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.register.customer.model.Customer;
import br.com.register.customer.service.CustomerService;

@RestController
@RequestMapping("customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Void> save (@Valid @RequestBody Customer customer) {
		customerService.save(customer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remove (@PathVariable("id") Long id){
		customerService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping
	public ResponseEntity<List<Customer>> list (){
		List<Customer> list =  customerService.list();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Customer> listById (@PathVariable("id") Long id) {
		Customer customer = customerService.listById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Customer> update (@Valid @RequestBody Customer customer){
		Customer customerUpdated = customerService.update(customer);
		return new ResponseEntity<Customer>(customerUpdated,HttpStatus.OK);
	}
}
