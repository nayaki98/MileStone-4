package com.example.stockspring.controller;

import java.sql.SQLException;

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
import com.example.stockspring.model.IPODetail;
import com.example.stockspring.service.IPODetailService;

@Controller
public class IPODetailControllerImpl implements IPODetailController {
	
	
	@Autowired
	private IPODetailService ipoService;


	
	@RequestMapping(path="/ipo")
	public String insertIPODetail(Model model) throws SQLException {
		IPODetail ipodetail=new IPODetail();
		model.addAttribute("ipo", ipodetail);
		return "ipodetail";
		
	}

	@RequestMapping(value = "/ipoInsert", method = RequestMethod.POST)
	public String submit(@ModelAttribute("ipo") @Valid IPODetail ipodetail, BindingResult result, Model model) throws SQLException {
		
		if(result.hasErrors()){
            
            return "ipodetail";
		}

		ipoService.insertIPODetail(ipodetail);
		
		return "redirect:/userlandingipo";
	}
	@RequestMapping(path="/userlandingipo")
	public String userLanding(Model model) throws Exception {
		
		return "userlanding";
	}


	
	
	
}
