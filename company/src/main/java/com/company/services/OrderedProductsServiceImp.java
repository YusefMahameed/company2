package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.models.orderedProducts;
import com.company.repositories.OrderedProductsRepository;

@Service
public class OrderedProductsServiceImp implements OrderedProductsService {

	@Autowired
	OrderedProductsRepository orderedProductsRepository;
	
	public List<orderedProducts> findAll() {
		// TODO Auto-generated method stub
		return orderedProductsRepository.findAll();
	}

	public orderedProducts creatOrderedProduct(orderedProducts p) {
		// TODO Auto-generated method stub
		return orderedProductsRepository.save(p);
	}

	public orderedProducts findById(int id) {
		// TODO Auto-generated method stub
		return orderedProductsRepository.findById(id);
	}

}
