package com.emre.springboot.crud.dao;

import java.util.List;

import com.emre.springboot.crud.entity.Customer;

public interface CustomerDAO {

	public List<Customer> findAll();
	
	public Customer findById(int theId);
	
	public void save(Customer theCustomer);
	
	public void deleteById(int theId);
}
