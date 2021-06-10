package com.cts.training.collateralwebportal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.cts.training.collateralwebportal.feign.LoanManagementClient;
import com.cts.training.collateralwebportal.model.ApplicationDao;
import com.cts.training.collateralwebportal.model.ApplicationIdDao;


import feign.FeignException;

@Controller
public class LoanApplicationController {

	@Autowired
	LoanManagementClient client;
	
	@RequestMapping(value="/loanapplication",method=RequestMethod.GET)
	public String showApplicationPage(@ModelAttribute("application") ApplicationDao application,ModelMap model) {
		return "application";
	}
	
	@RequestMapping(value="/loanapplication",method=RequestMethod.POST)
    public String submitApplication(@Valid @ModelAttribute("application")ApplicationDao application, 
      BindingResult result, ModelMap model) {
       
        if (result.hasErrors()) {
            model.put("errorMessage", "Invalid Details");
            return "application";
        }
		/*
		 * String token = "Bearer "+(String) request.getSession().getAttribute("token");
		 * CustomerLoan loan=null;
		 */
       
		    try {
		    	ApplicationDao app = client.applyLoan(application);
			 System.out.println("================inside Application=====================");
			model.addAttribute("app", app);
			System.out.println(app);
			return "application";
		    }
		    catch (FeignException e) {
				e.printStackTrace();
					return "application";
			}
	}
	@RequestMapping(value="/viewstatus",method=RequestMethod.GET)
	public String showViewStatus(@ModelAttribute("status") ApplicationIdDao application,ModelMap model) {
		return "applicationstatus";
	}

	@RequestMapping(value="/viewstatus",method=RequestMethod.POST)
	public String getStatus(@ModelAttribute("status") ApplicationIdDao application, ModelMap model) {
	
		try {
			ApplicationDao app = client.getStatus(application.getApplicationId());
			model.addAttribute("app",app);
			return "applicationstatus";
	    }
	    catch (FeignException e) {
			e.printStackTrace();
				return "applicationstatus";
		}
	}
	
}
