package com.cognizant.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Main.Loan;

@RestController
public class LoanController {

	@RequestMapping("/loans/{number}")
	public Loan getLoan(@PathVariable int number) {
		
		return new Loan("H00987987972342","car",40000,3258,18);
	}
}
