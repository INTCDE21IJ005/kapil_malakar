package com.cts.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.training.exception.CustomerLoanNotFoundException;
import com.cts.training.exception.LoanApplicationNotFoundException;
import com.cts.training.exception.LoanNotFoundException;
import com.cts.training.feign.AuthorisationClient;
import com.cts.training.model.CustomerLoan;
import com.cts.training.model.Loan_Application;
import com.cts.training.pojo.CashDeposit;
import com.cts.training.pojo.RealEstate;
import com.cts.training.service.LoanManagementService;

/**
 * This Class is marked as Rest Controller LoanManagementController
 * 
 * @ResquestMapping /loan-management
 */
@RestController
@RequestMapping(value = "/loan-management")
public class LoanManagementController {

	@Autowired
	private LoanManagementService loanService;

	@Autowired
	private AuthorisationClient authClient;

	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}

	/**
	 * getLoanDetails based on LoanId and CustomerId
	 * 
	 * @param token
	 * @param loanId
	 * @param customerId
	 * @return
	 * @throws CustomerLoanNotFoundException
	 */
	@GetMapping(value = "/getLoanDetails/{loanId}/{custId}")
	public CustomerLoan getLoanDetails(@RequestHeader(name = "Authorization") String token, @PathVariable int loanId,@PathVariable int custId) throws CustomerLoanNotFoundException {
		System.out.println("===============inside getloandetails================");
		if (authClient.validate(token)) {
			return loanService.getLoanDetails(loanId,custId);
		} else {
			throw new CustomerLoanNotFoundException(
					"Customer Loan Found With LoanId:" + loanId );
		}
	}

	/**
	 * This method saveRealEstateCollateral based on realEstate Object as parameter
	 * 
	 * @param token
	 * @param realEstate
	 * @return
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	@PostMapping(value = "/saveRealEstateCollateral")
	public ResponseEntity<String> saveRealEsateCollateral(@RequestHeader(name = "Authorization") String token,
			@RequestBody RealEstate realEstate) throws CustomerLoanNotFoundException, LoanNotFoundException {
		if (authClient.validate(token)) {
			return loanService.saveRealEstate(token, realEstate);
		} else {
			return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
		}
	}

	/**
	 * This method saveCashDepositeCollateral based on cashEstate Object as
	 * parameter
	 * 
	 * @param token
	 * @param cashDeposit
	 * @return
	 * @throws CustomerLoanNotFoundException
	 * @throws LoanNotFoundException
	 */
	@PostMapping(value = "/saveCashDepositCollateral")
	public ResponseEntity<String> saveCashDepositCollateral(@RequestHeader(name = "Authorization") String token,
			@RequestBody CashDeposit cashDeposit) throws CustomerLoanNotFoundException, LoanNotFoundException {
		if (authClient.validate(token)) {
			return loanService.saveCashDeposit(token, cashDeposit);
		} else {
			return new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
		}
	}
	@PostMapping(value="/applyLoan")
	public Loan_Application applyLoan(@RequestBody Loan_Application loanAppId) throws LoanApplicationNotFoundException {
		return loanService.applyLoan(loanAppId);
	}
	@GetMapping(value="/getLoanApplicationStatus/{loanAppId}")
	public Loan_Application getLoanStatus(@PathVariable int loanAppId) throws LoanApplicationNotFoundException {
		try {
			return loanService.getLoanApplicationStatus(loanAppId);
		} catch(LoanApplicationNotFoundException e) {
			throw new LoanApplicationNotFoundException("Loan Application Not Found " + loanAppId);
		}
	}
	@PutMapping(value="/approveLoanApplication/{loanAppId}")
	public Loan_Application approveLoanApplication(@RequestHeader(name = "Authorization") String token,@PathVariable int loanAppId) throws LoanApplicationNotFoundException {
		if (authClient.validate(token)) {
			return loanService.approveLoanApplication(token,loanAppId);
		} else {
			new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
			throw new LoanApplicationNotFoundException("Loan Application Not Found " + loanAppId);
		}
	
	}
	@PutMapping(value="/rejectLoanApplication/{loanAppId}")
	public Loan_Application rejectLoanApplication(@RequestHeader(name = "Authorization") String token,
			@PathVariable int loanAppId) throws LoanApplicationNotFoundException {
		if (authClient.validate(token)) {
			return loanService.rejectLoanApplication(token,loanAppId);
		} else {
			new ResponseEntity<>("Invalid token", HttpStatus.FORBIDDEN);
			throw new LoanApplicationNotFoundException("Loan Application Not Found " + loanAppId);
		}
	
	}
	}
