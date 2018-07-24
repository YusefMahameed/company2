package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.models.customers;
import com.company.models.products;
import com.company.repositories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<products> findByName(String name) {
		// TODO Auto-generated method stub
		return productRepository.findByName(name);
	}

	public List<products> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	public products creatProduct(products p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}

	public products findById(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

	public products updateProduct(products p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}

	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}
}
