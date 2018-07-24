package com.company.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.models.orderedProducts;

@Repository
public interface OrderedProductsRepository extends JpaRepository<orderedProducts, Integer>{
	orderedProducts findById(int id);
	List<orderedProducts> findAll();
}
