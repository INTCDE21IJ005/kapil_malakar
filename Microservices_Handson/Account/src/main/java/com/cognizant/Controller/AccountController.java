package com.cognizant.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Model.Account;

@RestController
public class AccountController {

	@RequestMapping("/accounts/{number}")
	public Account getAccount(@PathVariable int number) {
		
		return new Account("00987987973432","Savings",234343);
		
	}
}
