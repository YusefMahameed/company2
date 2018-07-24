package com.company.services;

import java.util.List;

import com.company.models.customers;
import com.company.models.orderedProducts;
import com.company.models.orders;
import com.company.models.products;

public interface OrderService {
	public List<orders> findByCustomer(customers customer);
	public List<orders> findByProduct(orderedProducts product);
	public List<orders> findAll();
	public orders creatOrder(orders o);
}




	

