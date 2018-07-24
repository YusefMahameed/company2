package com.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.models.currencies;
import com.company.models.orders;
import com.company.repositories.CurrencyRepository;

@Service
public class CurrencyServiceImp implements CurrencyService {

	@Autowired
    private CurrencyRepository currencyRepository;
	
	public List<currencies> findAll() {
		// TODO Auto-generated method stub
		return currencyRepository.findAll();
	}

	public currencies creatCurrency(currencies c) {
		// TODO Auto-generated method stub
		return currencyRepository.save(c);
	}

	public List<currencies> findByType(String type) {
		// TODO Auto-generated method stub
		return currencyRepository.findByType(type);
	}

	public currencies creatOrder(currencies c) {
		// TODO Auto-generated method stub
		return currencyRepository.save(c);
	}

	public currencies findById(int id) {
		// TODO Auto-generated method stub
		return currencyRepository.findById(id);
	}

}
