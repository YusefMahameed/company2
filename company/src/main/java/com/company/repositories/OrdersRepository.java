package com.company.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.models.customers;
import com.company.models.orderedProducts;
import com.company.models.orders;
import com.company.models.products;

@Repository
public interface OrdersRepository extends JpaRepository<orders, Long> {
	orders findById(int id);
	List<orders> findByCustomer(customers customer);
	List<orders> findByProduct(orderedProducts p);
}
