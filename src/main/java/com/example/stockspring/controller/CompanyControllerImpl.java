package com.example.stockspring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.example.stockspring.model.Company;
import com.example.stockspring.service.CompanyService;
import com.example.stockspring.service.CompanyServiceImpl;

@Controller
public class CompanyControllerImpl implements CompanyController{

	
	@Autowired
	private CompanyService service;
	
	
	public List<Company> getCompanyList() throws SQLException
	{
		return service.getCompanyList();
		
	}
	
	

	@RequestMapping(path="/companyList")
	public ModelAndView getCompanyList1() throws Exception {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("listcompany");
		mv.addObject("companyList",service.getCompanyList());
		return mv;
	}

	
	@RequestMapping(path="/company")
	public String insert(Model model) throws Exception {
		Company company=new Company();
		model.addAttribute("company", company);
		return "insertcompany";
	}
	@RequestMapping(value = "/insertCompany", method = RequestMethod.POST)
	public String submit(@ModelAttribute("company") @Valid Company company, BindingResult result, Model model) {
		
		if(result.hasErrors()){
            
            return "insertcompany";
		}

		service.insertCompany(company);
		return "redirect:/companyList";
	}
	@RequestMapping(path="/compareCompany")
	public String userLanding(Model model) throws Exception {
		
		return "userlanding";
	}


}




/*public boolean updateCompamy(int companyCode,String ceo) throws SQLException{
boolean result;
result=service.updateCompamy(companyCode, ceo);
return result;
}
public boolean removeCompanyDetails(int companycode) throws SQLException {
boolean result=service.removeCompanyDetails(companycode);
return result;

}*/
