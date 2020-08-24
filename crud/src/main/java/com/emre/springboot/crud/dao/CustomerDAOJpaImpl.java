package com.emre.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emre.springboot.crud.entity.Customer;

@Repository
public class CustomerDAOJpaImpl implements CustomerDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CustomerDAOJpaImpl(EntityManager theEntityManager) {

		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> findAll() {

		Query theQuery = entityManager.createQuery("from Customer");
		
		List<Customer> customers =  theQuery.getResultList();
		
		return customers;
	}

	@Override
	public Customer findById(int theId) {
		// get employee
		Customer theCustomer = 
				entityManager.find(Customer.class, theId);
		
		// return employee
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {

		// save or update the employee
		Customer dbCustomer = entityManager.merge(theCustomer);
		
		// update with id from db ... so we can get generated id for save/insert
		theCustomer.setId(dbCustomer.getId());

	}

	@Override
	public void deleteById(int theId) {
		// delete object with primary key
		Query theQuery = entityManager.createQuery(
							"delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();

	}

}
