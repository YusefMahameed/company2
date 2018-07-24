package com.company.services;

import java.util.List;

import com.company.models.currencies;

public interface CurrencyService {
	public List<currencies> findByType(String type);
	public List<currencies> findAll();
	public currencies creatCurrency(currencies c);
	currencies findById(int id);
}
