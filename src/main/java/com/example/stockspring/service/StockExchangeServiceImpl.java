package com.example.stockspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.stockspring.dao.StockExchangeDao;
import com.example.stockspring.model.StockExchange;


@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	@Autowired
	StockExchangeDao stockexchangedao;

	public void insertStockexchange(StockExchange stockExchange) {
		stockexchangedao.save(stockExchange);
		
	}

}
