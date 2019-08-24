package com.example.stockspring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockspring.model.Company;
import com.example.stockspring.model.StockExchange;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.StockExchangeService;


@Controller
public class StockExchangeControllerImpl implements StockExchangeController {
	
	@Autowired
	private StockExchangeService stockExchangeservice;
	
	@RequestMapping(path="/stockExchange")
	public String insert(Model model) throws Exception {
		StockExchange stockExchange=new StockExchange();
		model.addAttribute("stockExchange", stockExchange);
		return "stockexchange";
	}
	@RequestMapping(value = "/stockExchangeInsert", method = RequestMethod.POST)
	public String submit(@ModelAttribute("stockExchange") @Valid StockExchange stockExchange, BindingResult result, Model model) {
		
		if(result.hasErrors()){
            
            return "stockexchange";
		}

		stockExchangeservice.insertStockexchange(stockExchange);
		return "redirect:/userlandingstockExchange";
	}
	@RequestMapping(path="/userlandingstockExchange")
	public String userLanding(Model model) throws Exception {
		
		return "userlanding";
	}
	
	
}
