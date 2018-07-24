package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.models.customers;
import com.company.models.orderedProducts;
import com.company.models.orders;
import com.company.models.products;
import com.company.repositories.OrdersRepository;

@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	OrdersRepository orderRepository;
	
	public List<orders> findByCustomer(customers customer) {
		// TODO Auto-generated method stub
		return orderRepository.findByCustomer(customer);
	}

	public List<orders> findAll() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	public orders creatOrder(orders o) {
		// TODO Auto-generated method stub
		return orderRepository.save(o);
	}

	public List<orders> findByProduct(orderedProducts p) {
		// TODO Auto-generated method stub
		return orderRepository.findByProduct(p);	
	}

}
