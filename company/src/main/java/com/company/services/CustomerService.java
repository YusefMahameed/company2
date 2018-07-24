package com.company.services;

import java.util.List;

import com.company.models.customers;

public interface CustomerService {
	public List<customers> findByName(String name);
	public List<customers> findAll();
	public customers creatCustomer(customers c);
	public customers findById(int id);
}
