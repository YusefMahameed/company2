package com.company.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.models.*;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<customers, Long> {
    List<customers> findByName(String name);
    customers findById(int id);
}
