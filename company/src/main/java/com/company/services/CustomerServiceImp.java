package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.models.customers;
import com.company.repositories.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	
	
	 @Autowired
	    private CustomerRepository customerRepository;

	public List<customers> findByName(String name) {
		// TODO Auto-generated method stub
		return customerRepository.findByName(name);
	}

	public List<customers> findAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public customers creatCustomer(customers c) {
		// TODO Auto-generated method stub
		return customerRepository.save(c);
	}

	
	public customers findById(int id) {
		return customerRepository.findById(id);
		
	}
}
