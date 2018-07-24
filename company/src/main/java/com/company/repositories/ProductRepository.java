package com.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.models.*;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<products, Integer> {
	List<products> findByName(String name);
	products findById(int id);
	void deleteById(Integer id);
	products save(products p);
	
}
