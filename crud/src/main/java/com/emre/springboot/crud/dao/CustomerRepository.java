package com.emre.springboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.springboot.crud.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
