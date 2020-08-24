package com.emre.springboot.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emre.springboot.crud.dao.CustomerRepository;
import com.emre.springboot.crud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl( CustomerRepository theCustomerRepository) {
		customerRepository = theCustomerRepository;
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int theId) {
		Optional<Customer> result = customerRepository.findById(theId);
		
		Customer theCustomer=null;
		
		if(result.isPresent()) {
			theCustomer=result.get();
		}
		else {
			throw new RuntimeException("did not find customer id -" + theId);
		}
		
		return theCustomer;
	}

	@Override
	@Transactional
	public void save(Customer theCustomer) {
		
		customerRepository.save(theCustomer);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		
		customerRepository.deleteById(theId);
	}
	
	

}
