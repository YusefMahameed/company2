package com.company.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.models.currencies;

@Repository
public interface CurrencyRepository extends JpaRepository<currencies, Long>{
	List<currencies> findByType(String type);
	currencies findById(int id);
}
