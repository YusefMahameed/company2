package com.company.services;

import java.util.List;

import com.company.models.products;

public interface ProductService {
	public List<products> findByName(String name);
	public List<products> findAll();
	public products creatProduct(products p);
	public products findById(int id);
	public products updateProduct(products p);
	public void deleteProduct(int id);
}
