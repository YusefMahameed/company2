package com.company.services;

import java.util.List;

import com.company.models.orderedProducts;

public interface OrderedProductsService {
	public List<orderedProducts> findAll();
	public orderedProducts creatOrderedProduct(orderedProducts p);
	public orderedProducts findById(int id);
}
