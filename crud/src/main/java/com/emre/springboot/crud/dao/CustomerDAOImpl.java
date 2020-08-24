package com.emre.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emre.springboot.crud.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	private EntityManager entityManager; 
	
	@Autowired
	public CustomerDAOImpl( EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Customer> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Customer> theQuery=
				currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}

	@Override
	public Customer findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Customer theCustomer=currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void save(Customer theCustomer) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCustomer);
		
	}

	@Override
	public void deleteById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Customer where id = :theId");
		
		theQuery.setParameter("theId",theId);
		
		theQuery.executeUpdate();

		
	}

}
